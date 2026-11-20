# BlackBattleship

Testes de caixa-preta / aceitação sobre o jogo de batalha naval online
[papergames.io/en/battleship](https://papergames.io/en/battleship), no âmbito da
**Ficha laboratorial nº 5** de **Engenharia de Software (2026/2027)** — LEI / LEI-PL / LETI, ISCTE.

O objetivo não é testar o *site* da JetBrains: esse projeto (`MainPage` / `MainPageTest`) serve apenas de
projeto-piloto para validar o ambiente. O alvo real é o jogo, e cada *user story* do backlog é validada
por um par de classes que segue o padrão **Page Object Model**.

---

## Elementos do grupo

| Nº      | Nome completo   | Conta GitHub   | Test suite (Parte 2)     |
| ------- | --------------- | -------------- | ------------------------ |
| «nº»    | «Nome»          | «@utilizador»  | «UserStoryTest1»         |
| «nº»    | «Nome»          | «@utilizador»  | «UserStoryTest2»         |
| «nº»    | «Nome»          | «@utilizador»  | «UserStoryTest3»         |
| «nº»    | «Nome»          | «@utilizador»  | «UserStoryTest4»         |

> **Preencher antes do primeiro commit** — a tabela é parte da evidência do critério
> «Setup do projeto e Product Backlog» (25%).
>
> Responsabilidades fixadas pela ficha:
> * elemento com o **2.º número mais baixo** → importa/partilha o projeto inicial (Parte 1-A);
> * elemento com o **2.º número mais alto** → cria a *tag* final no último commit (Parte 2, ponto 6).

## Vídeo de demonstração

«Link do vídeo no YouTube (máx. 5 min) — a colocar no fim do trabalho.»

---

## Âmbito do trabalho

| Parte | Ferramentas | O que é entregue |
| ----- | ----------- | ---------------- |
| **1-A** | IntelliJ, Maven, JUnit 5 | Projeto-piloto importado, `pom.xml` revisto, `reports/`, README, execução de `MainPageTest` |
| **1-B** | Selenium WebDriver + JUnit 5 + POM | Cenários gravados no Selenium IDE (`.side`) e convertidos em Page Object Class + Page Test Class, ≥ 4 user stories por elemento |
| **2** | Selenide + Allure Report | A mesma bateria reescrita em Selenide, relatórios Allure em `reports/`, Issues + branches + Pull Requests + *tag* |
| **Vídeo** | YouTube | Demonstração da execução das *test suites* da Parte 2 (≤ 5 min) |

Ponderação: Setup + Backlog **25%**, Selenium **30%**, Selenide + Allure **30%**, vídeo **15%**.

## Tecnologias

| Dependência | Versão | Para quê |
| ----------- | ------ | -------- |
| JDK | 23+ (compila com `--release 23`) | linguagem e *toolchain* |
| JUnit Jupiter | 5.14.4 | `@Test`, `@BeforeEach`, `@AfterEach`, asserções |
| JUnit Platform Launcher | 1.14.4 | tem de estar **alinhado** com o Jupiter, senão o Surefire não descobre testes |
| Selenium WebDriver | 4.53.0 | automação do browser (Parte 1) |
| Selenide | 7.19.1 | automação mais concisa (Parte 2) |
| Allure Report | 2.35.6 (`allure-jupiter`) | relatórios de execução |
| AspectJ Weaver | 1.9.27 | `-javaagent` exigido pelo Allure |
| Maven Surefire | 3.6.1 | execução dos testes na fase `test` |

O *driver* do browser não é versionado: o **Selenium Manager** descarrega o `chromedriver` compatível com o
Chrome instalado (fica em `chromedriver/`, ignorado pelo Git).

## Estrutura do repositório

```
BlackBattleship/
├── pom.xml                          # dependências + Surefire + Allure
├── README.md                        # este ficheiro
├── browsers.json                    # browsers/versões para execução remota e CI/CD
├── docs/                            # guia de execução e registo do estado
├── reports/                         # relatórios Allure exportados (versionados)
├── src/
│   ├── main/java/iscteiul/ista/blackbattleship/   # Page Object Classes  <- Parte 1-B
│   ├── test/java/iscteiul/ista/blackbattleship/   # Page Test Classes (JUnit)
│   └── test/resources/allure.properties           # allure.results.directory
└── target/allure-results/           # resultados brutos do Allure (gerado, não versionado)
```

Convenção obrigatória da ficha — cada *user story* origina **duas** classes:

```
src/main/java/iscteiul/ista/blackbattleship/UserStoryN.java       # localizadores + operações (Page Object)
src/test/java/iscteiul/ista/blackbattleship/UserStoryNTest.java   # código JUnit que usa a classe anterior
```

## Product Backlog

«Scrum Product Backlog em markdown, com as user stories numeradas (US1..USn) levantadas a partir das
páginas reais do jogo. Cada US indica ator, ação, valor e critérios de aceitação.»

| ID  | User story (como… quero… para…) | Critérios de aceitação | Responsável | Estado |
| --- | ------------------------------- | ---------------------- | ----------- | ------ |
| US1 | «…»                             | «…»                    | «…»         | ⬜     |
| US2 | «…»                             | «…»                    | «…»         | ⬜     |
| US3 | «…»                             | «…»                    | «…»         | ⬜     |
| US4 | «…»                             | «…»                    | «…»         | ⬜     |

Regras práticas ao escrever as US:

* uma US por funcionalidade observável na UI (criar partida, escolher tamanho do tabuleiro, colocar navios,
  disparar, ver histórico, terminar jogo, ver resultado…);
* critérios de aceitação escritos como comportamento visível (URL, texto do turno, estado do botão),
  nunca como detalhe de implementação — o teste não pode conhecer o interior da aplicação;
* evitar critérios que dependam de aleatoriedade do jogo ou de um adversário humano (fonte clássica de
  testes intermitentes).

## Como executar

Requisitos: **JDK 23+** (o *wrapper* usa o `JAVA_HOME`), **Maven 3.9+** (ou `./mvnw`) e **Google Chrome**
(Edge/Firefox também funcionam, configuráveis em `browsers.json`).

```bash
# compilar (main + test)
./mvnw -q test-compile

# correr toda a bateria
./mvnw test

# correr uma classe ou um único teste
./mvnw test -Dtest=MainPageTest
./mvnw test -Dtest=UserStoryTest1

# um teste específico dentro da classe
./mvnw test -Dtest=UserStoryTest1#colocarNavio
```

No IntelliJ: abrir a pasta do projeto, confirmar `Project SDK 23+`, e correr a classe de teste pelo
botão ▶ (o `pom.xml` já traz o `-javaagent` do Allure na `argLine` do Surefire).

### Problemas conhecidos

| Sintoma | Causa / solução |
| ------- | --------------- |
| `mvnw` falha com `FileNotFoundException … maven-wrapper.jar.zip.part` | `~/.m2` não é escrevível; usar o Maven do IDEA ou `-Dmaven.repo.local=<pasta escrevível>` |
| `TestEngine with ID 'junit-jupiter' failed to discover tests` | `junit-platform-launcher` desalinhado do Jupiter — já corrigido no `pom.xml`, não alterar as versões isoladamente |
| `session not created: Chrome failed to start` | o processo do Chrome não arranca no ambiente atual (permissões/sandbox); correr a partir de um terminal normal ou do IntelliJ |
| Elemento não encontrado apesar de estar visível | conteúdo em `iframe`/`canvas`, ou falta espera explícita |
| Testes intermitentes | estado do jogo (aleatório, adversário, temporizador) — asserções devem usar sinais estáveis |

## Relatórios Allure

Os resultados brutos vão para `target/allure-results` (definido em `src/test/resources/allure.properties`).
O relatório é gerado com o **Allure Report CLI** e copiado para `reports/`, num diretório cujo nome
identifica a *test suite* e o momento de criação:

```bash
./mvnw test
allure generate target/allure-results -o reports/UserStoryTest1-allure-report --clean
allure open reports/UserStoryTest1-allure-report        # pré-visualizar
```

No IntelliJ também se pode usar `Allure Report > Generate…` / `Generate On-The-Fly…` (plugin *Allure
TestOps Support*).

## Fluxo de trabalho (Git)

1. **Issue** por *test suite*, aberto no repositório partilhado antes de começar.
2. **Branch** de trabalho por elemento e por *suite*: `test-suite/userstory2`.
3. **Um commit por user story**, com o identificador na mensagem:
   `UserStoryTest2: colocação de navios no tabuleiro`.
4. **Push** do branch + **Pull Request** para `main`, revisto por outro elemento do grupo.
5. Fechar o **Issue** depois do *merge* na `main` remota.
6. **Tag** final no último commit, criada pelo elemento com o 2.º número mais alto.

Convenções de código:

* localizadores só na Page Object Class (`@FindBy` / `By.cssSelector` / `By.xpath`), nunca na classe de teste;
* classes e métodos comentados com **Javadoc**;
* esperas explícitas (`WebDriverWait`, `Selenide` já espera por omissão) em vez de `Thread.sleep`;
* `@BeforeEach` / `@AfterEach` para criar e fechar o `WebDriver`.

## Estado atual

* [x] `pom.xml` com Selenium, JUnit 5, Selenide, Allure e Surefire configurados
* [x] estrutura Maven (`src/main/java`, `src/test/java`, `src/test/resources`), `reports/`, `allure.properties`
* [x] `MainPage` / `MainPageTest` (projeto-piloto) a compilar; execução do teste validada
* [x] README, `docs/` e `.gitignore`
* [ ] tabela de elementos do grupo preenchida
* [ ] Product Backlog (US1..USn) escrito e revisto
* [ ] cenários `.side` gravados no Selenium IDE
* [ ] Page Object + Page Test das user stories (Parte 1-B)
* [ ] bateria em Selenide + relatórios Allure em `reports/` (Parte 2)
* [ ] Issues, Pull Requests e *tag* finais
* [ ] vídeo de demonstração publicado no YouTube

## Referências

* Ficha laboratorial nº 5 — Moodle da UC (Laboratórios / ficha 5)
* Selenium: <https://www.selenium.dev/documentation/>
* Selenide: <https://selenide.org/documentation/>
* Allure Report: <https://allurereport.org/docs/>
* Selenium IDE: <https://www.selenium.dev/selenium-ide/>
* Jogo sob teste: <https://papergames.io/en/battleship>
