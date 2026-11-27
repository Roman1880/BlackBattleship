# BlackBattleship

Testes de caixa-preta / aceitação sobre o jogo de batalha naval online
[papergames.io/en/battleship](https://papergames.io/en/battleship), no âmbito da
**Ficha laboratorial nº 5** de **Engenharia de Software (2026/2027)** — LEI / LEI-PL / LETI, ISCTE.

O objetivo não é testar o *site* da JetBrains: esse projeto (`MainPage` / `MainPageTest`) serve apenas de
projeto-piloto para validar o ambiente. O alvo real é o jogo, e cada *user story* do backlog é validada
por um par de classes que segue o padrão **Page Object Model**.

---

## Elementos do grupo

| Nº       | Nome completo      |  Test suite (Parte 2)    |
|----------|--------------------|  ------------------------|
| «124359» | «Roman Havrylenko» | «UserStoryTest1»         |
| «122669» | «Luo Hang»         | «UserStoryTest2»         |
| «124109» | «Salvador Gomes»   | «UserStoryTest3»         |
| «87711»  | «José Gil»         | «UserStoryTest4»         |

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

## Product Backlog — BlackBattleship (Papergames.io)

| ID | User story (como… quero… para…) | Critérios de aceitação | Responsável | Estado |
| --- | --- | --- | --- | --- 
| US1 | Como jogador, quero iniciar uma partida de Batalha Naval contra um robô (`https://papergames.io/en/battleship`), para poder treinar as regras e jogar mesmo sem adversários humanos disponíveis. | O tabuleiro do jogo é carregado, o jogador pode posicionar os navios e iniciar o combate contra a inteligência artificial sem erros. |124359| ✅ |
| US2 | Como jogador, quero procurar um adversário online aleatório na página do jogo (`https://papergames.io/en/battleship`), para disputar uma partida competitiva em tempo real. | Ao clicar na opção de jogar online, o sistema inicia a procura de um oponente e estabelece a ligação à partida. |124359| ✅ |
| US3 | Como jogador, quero gerar um link de convite na página da Batalha Naval (`https://papergames.io/en/battleship`), para jogar diretamente contra um colega específico. | É gerado um URL único e copiável que permite a outro utilizador entrar diretamente na mesma sala de jogo. |124359| ✅ |
| US4 | Como utilizador, quero definir ou editar o meu nome de jogador (nickname), para ser identificado nas partidas, nos torneios e nas tabelas de classificação. | O novo nickname é guardado com sucesso e passa a ser exibido na interface durante as partidas e no perfil. |124359| ✅ |
| US5 | Como novo jogador, quero aceder aos guias e instruções do jogo (`https://papergames.io/docs/game-guides/`), para compreender a disposição dos navios e as regras específicas da Batalha Naval nesta plataforma. | A página de documentação abre corretamente e apresenta as regras detalhadas do jogo de Batalha Naval. |122669| ⬜ |
| US6 | Como jogador, quero posicionar manualmente ou de forma aleatória os meus navios na grelha antes do início da batalha (`https://papergames.io/en/battleship`), para preparar a minha estratégia defensiva. | Os navios podem ser movidos, rodados ou distribuídos aleatoriamente dentro dos limites da grelha antes de confirmar o início da partida. |122669| ⬜ |
| US7 | Como jogador, quero clicar nas coordenadas do tabuleiro adversário durante o meu turno (`https://papergames.io/en/battleship`), para tentar atingir e afundar a frota inimiga. | O clique numa célula válida regista o disparo e indica visualmente se foi água, acerto num navio ou navio afundado. |122669| ⬜ |
| US8 | Como organizador, quero criar um campeonato configurado para o jogo Battleships (`https://papergames.io/en/t/create-tournament?game=Battleships`), para competir com vários jogadores simultaneamente. | O formulário de criação permite definir as regras do torneio de Battleships e gera uma página de competição ativa. |122669| ⬜ |
| US9 | Como utilizador, quero aceder à lista dos meus torneios (`https://papergames.io/en/t/my-tournaments`), para acompanhar o estado e os resultados das competições em que participo. | A página apresenta os torneios criados ou em que o utilizador está inscrito, bem como o respetivo estado. |87711| ⬜ |
| US10 | Como utilizador, quero visualizar os benefícios dos planos Plus e Gruppo (`https://papergames.io/en/pricing/plus`, `https://papergames.io/en/pricing/gruppo`), para avaliar funcionalidades adicionais na plataforma. | As páginas de subscrição apresentam claramente as vantagens e os valores de cada plano. |87711| ⬜ |
| US11 | Como jogador, quero aceder à funcionalidade de chat (`https://papergames.io/en/chat`), para comunicar com outros utilizadores e amigos na plataforma. | A janela de conversação abre e permite enviar e visualizar mensagens de texto sem falhas. |87711| ⬜ |
| US12 | Como jogador, quero visualizar o meu histórico de jogos anteriores (`https://papergames.io/en/match-history`), para rever vitórias, derrotas e estatísticas. | A página exibe o registo das partidas concluídas com a indicação do adversário e do resultado final. |87711| ⬜ |
| US13 | Como utilizador, quero explorar e adquirir avatares, emojis e moedas virtuais na loja (`https://papergames.io/en/shop`), para personalizar a minha conta durante as partidas. | As secções da loja (avatares, emojis e moedas virtuais) carregam os respetivos itens e preços corretamente. | | ⬜ |
| US14 | Como jogador, quero adicionar, visualizar e gerir amigos (`https://papergames.io/en/friends`), para facilitar o convite para futuras partidas. | A lista de amigos é carregada corretamente, permitindo pesquisar utilizadores e gerir pedidos de amizade. | | ⬜ |
| US15 | Como jogador competitivo, quero aceder ao sistema de classificação (`https://papergames.io/en/blog/ranka`), para verificar a minha posição face a outros jogadores. | A página explica o funcionamento do sistema de ranking e exibe as informações de classificação. | | ⬜ |

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

* ---

## Notas sobre a Execução dos Testes Automatizados (Selenium WebDriver e Selenide)

Os cenários de teste (**US1**, **US2**, **US3** e **US4**) foram gravados e validados com sucesso no Selenium IDE (`TestSuite_124359.side`), utilizando uma sessão de navegador previamente iniciada como convidado (*Guest*).

No entanto, durante a execução automatizada via JUnit / Maven (`FirefoxDriver` tanto em Selenium WebDriver como em Selenide), o navegador inicia numa instância limpa e isolada (sem *cookies* nem armazenamento local de sessões anteriores). Por esse motivo, a plataforma **Papergames.io** apresenta a janela de registo ou criação de nome de utilizador convidado (*Guest Login*) antes de permitir o acesso às salas de jogo, o que explica os resultados obtidos na suíte Selenide (**2 testes aprovados e 2 falhados**):

* **Testes aprovados (`UserStory2SelenideTest` e `UserStory4SelenideTest`):** as ações iniciais de seleção de modo online (`testPlayOnlineRandomOpponent`) e interação com o menu superior (`testChangeNickname`) conseguem prosseguir até ao ponto verificado pelo teste.
* **Testes falhados (`UserStory1SelenideTest` e `UserStory3SelenideTest`):**
  * Em `UserStory1SelenideTest` (`testPlayAgainstRobot`), ocorre `Element not found {.cell-1-3 .circle}` (*Timeout: 4 s*), pois o tabuleiro de posicionamento da frota não é carregado sem a autenticação prévia de convidado.
  * Em `UserStory3SelenideTest` (`testInviteFriendWithLink`), ocorre `Element not found {.fa-copy}` (*Timeout: 4 s*), uma vez que o ecrã de partilha de convite (ícone de copiar link) não é apresentado antes de introduzir um *nickname*.
