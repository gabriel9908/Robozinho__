# 🤖 Robô de Investimentos (InvestBot)

Sistema automatizado de análise e execução de operações na bolsa de valores usando Java, Spring Boot e web scraping.

## 🚀 Tecnologias

- Java 17
- Spring Boot 3.1.5
- PostgreSQL
- Docker & Docker Compose
- JSoup (Web Scraping)
- Maven
- JUnit 5
- Lombok

## 📋 Pré-requisitos

- Java 17+
- Maven 3.8+
- Docker & Docker Compose
- Git

## 🛠️ Instalação

1. Clone o repositório:
```bash
git clone https://github.com/gabriel9908/Robozinho__.git
cd Robozinho__
```

2. Compile o projeto:
```bash
mvn clean package
```

3. Inicie os containers:
```bash
docker-compose up -d
```

## 💻 Uso

O sistema estará disponível em:
- API REST: http://localhost:8080/api
- Adminer (Gerenciador DB): http://localhost:8081

Credenciais do banco de dados:
- Host: localhost:5432
- Database: investbot
- Username: postgres
- Password: postgres

## 🔎 Funcionalidades

1. **Web Scraping**
   - Coleta automática de dados da B3
   - Análise de dados fundamentalistas
   - Monitoramento de preços em tempo real

2. **Análise Técnica**
   - Médias móveis
   - RSI (Índice de Força Relativa)
   - Bandas de Bollinger

3. **Análise Fundamentalista**
   - P/L (Preço/Lucro)
   - ROE (Retorno sobre Patrimônio)
   - Dívida/Patrimônio

4. **Execução de Ordens**
   - Compra e venda automática
   - Gestão de carteira
   - Controle de risco

## 📖 Documentação

- [Documentação da API](API.md)
- Swagger UI: http://localhost:8080/swagger-ui.html

## 🧪 Testes

Execute os testes com:
```bash
mvn test
```

## 📊 Monitoramento

- Actuator: http://localhost:8080/actuator
- Métricas: http://localhost:8080/actuator/metrics
- Health Check: http://localhost:8080/actuator/health

## 🤝 Contribuindo

1. Fork o projeto
2. Crie uma branch para sua feature (`git checkout -b feature/AmazingFeature`)
3. Commit suas mudanças (`git commit -m 'Add some AmazingFeature'`)
4. Push para a branch (`git push origin feature/AmazingFeature`)
5. Abra um Pull Request

## 📝 Licença

Este projeto está sob a licença MIT. Veja o arquivo [LICENSE](LICENSE) para mais detalhes.

## 👤 Autor

Gabriel
- GitHub: [@gabriel9908](https://github.com/gabriel9908)