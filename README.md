🎬 Projeto de Filmes (App Android Nativo)

Este é um aplicativo Android nativo desenvolvido como um exercício prático para demonstrar os fundamentos da arquitetura moderna de aplicativos Android, focando no armazenamento local de dados.

O app permite que o usuário mantenha uma lista pessoal de filmes, realizando as quatro operações básicas de CRUD (Criar, Ler, Atualizar, Excluir) em um banco de dados local no dispositivo.

✨ Funcionalidades

O aplicativo implementa um sistema completo de gerenciamento de filmes:

Salvar Filme (Create): Um formulário permite ao usuário adicionar um novo filme (título, ano, sinopse) ao banco de dados.

Listar Filmes (Read): A tela principal exibe uma lista de todos os filmes salvos, que é atualizada automaticamente em tempo real (reativa).

Atualizar Filme (Update): O usuário pode selecionar um filme da lista para atualizar seus dados.

Excluir Filme (Delete): O usuário pode excluir um filme da lista.

🛠️ Tecnologias e Arquitetura

Este projeto foi construído utilizando as ferramentas e bibliotecas recomendadas pelo Google (Jetpack), seguindo uma arquitetura MVVM (Model-View-ViewModel).

Linguagem: Kotlin (100% Kotlin)

UI (Interface de Usuário): Jetpack Compose (para uma UI declarativa e moderna)

Arquitetura: MVVM (Model-View-ViewModel)

Banco de Dados Local: Room (para persistência de dados robusta e abstração de SQLite)

Assincronismo: Kotlin Coroutines (para operações de I/O, como acessar o banco de dados, fora da thread principal)

Reatividade: StateFlow (usado no ViewModel para expor a lista de filmes de forma reativa, para que a UI se atualize automaticamente)

Injeção de Dependência (Manual):

Uma classe MyFilmesApplication customizada é usada para criar uma instância única (Singleton) do banco de dados.

Uma ViewModelFactory personalizada (MovieViewModel.Factory) é usada para injetar o MovieDao no MovieViewModel.

📂 Estrutura do Projeto

O código-fonte está organizado nos seguintes pacotes principais:

com.example.projetodefilmes

MainActivity.kt: Ponto de entrada da aplicação, responsável por configurar a UI principal.

MyFilmesApplication.kt: Classe de aplicação customizada para inicializar o banco de dados.

data/: Contém toda a lógica de dados (o "Model" do MVVM).

Movie.kt: A classe de entidade (@Entity) que define a tabela "movies" no banco.

MovieDao.kt: A interface (@Dao) que define as operações de banco de dados (CRUD).

AppDatabase.kt: A classe abstrata (@Database) que configura o banco de dados Room.

ui/: Contém a lógica de UI e estado (o "View" e o "ViewModel").

MovieViewModel.kt: O ViewModel, que atua como ponte entre a UI e o repositório de dados.

MovieListScreen.kt: O @Composable que desenha a tela, observa o estado do ViewModel e reage a eventos do usuário.

theme/: Pacote padrão do Compose para definição de cores, fontes e tema.

🚀 Como Executar

Clone este repositório:

git clone https://github.com/joaovbressan/-projeto-de-Filmes.git


Abra o projeto no Android Studio (versão Hedgehog ou mais recente).

Aguarde o Gradle sincronizar todas as dependências (pode levar alguns minutos).

Execute o aplicativo em um emulador ou dispositivo físico clicando no botão "Run 'app'" (▶).

Este projeto foi desenvolvido como um exercício prático. O próximo passo lógico seria integrar uma API externa, como a do The Movie Database (TMDB), para buscar filmes online em vez de cadastrá-los manualmente.
