🔧 garage-hub

A central hub for managing vehicle service orders, customers, parts and workshop operations — built with DDD principles and clean architecture.


📋 Sobre o Projeto
O garage-hub é o back-end MVP de um Sistema Integrado de Atendimento e Execução de Serviços para oficinas mecânicas. O sistema permite gerenciar ordens de serviço, clientes, veículos e peças, com acompanhamento em tempo real e autorização de reparos via API.
Projeto desenvolvido como Tech Challenge — Fase 1 da Pós-Tech SOAT (Software Architecture).

🚀 Funcionalidades

✅ Criação e gestão de Ordens de Serviço (OS)
✅ Acompanhamento de status da OS em tempo real
✅ CRUD de clientes (CPF/CNPJ)
✅ CRUD de veículos (placa, marca, modelo, ano)
✅ CRUD de serviços
✅ CRUD de peças e insumos com controle de estoque
✅ Geração automática de orçamento
✅ Aprovação de orçamento via API
✅ Autenticação JWT para APIs administrativas
✅ Monitoramento de tempo médio de execução


🔄 Ciclo de Vida da Ordem de Serviço
Recebida → Em Diagnóstico → Aguardando Aprovação → Em Execução → Finalizada → Entregue

🛠️ Tecnologias
TecnologiaUso[Linguagem/Framework]Back-end principal[Banco de dados]Persistência de dadosDockerContainerizaçãoDocker ComposeOrquestração do ambienteJWTAutenticação e autorizaçãoSwagger/OpenAPIDocumentação das APIs

⚠️ Preencha com as tecnologias escolhidas pelo grupo.


📐 Arquitetura
O projeto utiliza arquitetura monolítica em camadas com princípios de Domain-Driven Design (DDD):
garage-hub/
├── src/
│   ├── domain/          # Entidades, Value Objects, Agregados
│   ├── application/     # Casos de uso e serviços de aplicação
│   ├── infrastructure/  # Repositórios, banco de dados, JWT
│   └── presentation/    # Controllers, rotas, DTOs
├── tests/
│   ├── unit/
│   └── integration/
├── docs/                # Documentação DDD (Event Storming, diagramas)
├── Dockerfile
├── docker-compose.yml
└── README.md

⚙️ Como Executar Localmente
Pré-requisitos

Docker instalado
Docker Compose instalado

Passo a passo
1. Clone o repositório
bashgit clone https://github.com/<seu-usuario>/garage-hub.git
cd garage-hub
2. Configure as variáveis de ambiente
bashcp .env.example .env
# Edite o arquivo .env com suas configurações
3. Suba o ambiente completo
bashdocker-compose up --build
4. Acesse a aplicação

API: http://localhost:3000
Swagger: http://localhost:3000/api-docs


🔐 Autenticação
As rotas administrativas são protegidas por JWT. Para acessá-las:
1. Obtenha o token:
httpPOST /auth/login
Content-Type: application/json

{
  "email": "admin@garagehub.com",
  "password": "sua-senha"
}
2. Use o token nas requisições:
httpAuthorization: Bearer <seu-token>

Documentação completa disponível no Swagger após subir o ambiente.


🧪 Testes
bash# Executar todos os testes
npm test

# Executar com cobertura
npm run test:coverage

Cobertura mínima exigida: 80% nos domínios críticos.


📚 Documentação DDD
A documentação de Domain-Driven Design está disponível em:

📌 Event Storming e Diagramas: Link do Miro
📖 Linguagem Ubíqua: docs/ubiquitous-language.md

Bounded Contexts identificados
ContextoResponsabilidadeAtendimentoGestão de clientes e veículosOrdem de ServiçoCiclo de vida completo da OSExecuçãoServiços e tempo de execuçãoEstoquePeças, insumos e controle de estoqueOrçamentoPrecificação e aprovação

🔍 Análise de Vulnerabilidades
O relatório com análise de segurança e scan de vulnerabilidades está disponível em:
docs/security-report.md

👥 Equipe
NomeDiscord[Nome do integrante]@username[Nome do integrante]@username[Nome do integrante]@username

📄 Licença
Este projeto foi desenvolvido para fins acadêmicos — Pós-Tech SOAT / FIAP.
