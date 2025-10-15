# 📚 Documentação da API

## 🔑 Autenticação

A API utiliza autenticação via Bearer Token. Inclua o token no header de todas as requisições:
```
Authorization: Bearer seu-token-aqui
```

## 🔍 Endpoints

### Ações (Stocks)

#### Listar todas as ações
```http
GET /api/stocks
```

**Resposta**
```json
[
  {
    "symbol": "PETR4",
    "name": "Petrobras PN",
    "sector": "Petróleo",
    "currentPrice": 30.50,
    "variation": 2.5,
    "volume": 1000000,
    "lastUpdate": "2025-10-15T10:30:00"
  }
]
```

#### Obter ação específica
```http
GET /api/stocks/{symbol}
```

**Resposta**
```json
{
  "symbol": "PETR4",
  "name": "Petrobras PN",
  "sector": "Petróleo",
  "currentPrice": 30.50,
  "variation": 2.5,
  "volume": 1000000,
  "lastUpdate": "2025-10-15T10:30:00"
}
```

### Análises (Analysis)

#### Obter análise de uma ação
```http
GET /api/analysis/{symbol}
```

**Resposta**
```json
{
  "stockSymbol": "PETR4",
  "trend": "BULLISH",
  "recommendation": "BUY",
  "supportLevel": 29.50,
  "resistanceLevel": 31.75,
  "technicalAnalysis": "Tendência de alta confirmada...",
  "fundamentalAnalysis": "Indicadores fundamentalistas sólidos...",
  "analysisDate": "2025-10-15T10:30:00"
}
```

#### Listar análises por recomendação
```http
GET /api/analysis/recommendation/{type}
```

**Parâmetros**
- type: BUY, SELL, HOLD

### Operações (Trades)

#### Executar ordem
```http
POST /api/trades
```

**Corpo da requisição**
```json
{
  "stockSymbol": "PETR4",
  "type": "BUY",
  "quantity": 100,
  "price": 30.50,
  "strategy": "MOVING_AVERAGE"
}
```

#### Listar operações
```http
GET /api/trades
```

#### Cancelar ordem
```http
PUT /api/trades/{id}/cancel
```

## 📊 Códigos de Status

- 200: Sucesso
- 201: Criado
- 400: Requisição inválida
- 401: Não autorizado
- 403: Proibido
- 404: Não encontrado
- 500: Erro interno do servidor

## 📝 Formatos

### Data e Hora
Todas as datas são retornadas no formato ISO 8601:
```
YYYY-MM-DDThh:mm:ss
```

### Números
- Valores monetários: Decimal com 2 casas
- Porcentagens: Decimal com 2 casas
- Volumes: Inteiros

## 🔒 Limites de Taxa

- 100 requisições por minuto por IP
- 1000 requisições por hora por usuário

## 📌 Ambiente de Testes

Disponível em: http://localhost:8080/api

## 🧪 Exemplos de Uso

### cURL
```bash
# Listar ações
curl -X GET http://localhost:8080/api/stocks \
  -H "Authorization: Bearer seu-token"

# Executar ordem
curl -X POST http://localhost:8080/api/trades \
  -H "Authorization: Bearer seu-token" \
  -H "Content-Type: application/json" \
  -d '{
    "stockSymbol": "PETR4",
    "type": "BUY",
    "quantity": 100,
    "price": 30.50
  }'
```

## 🚨 Tratamento de Erros

Exemplo de resposta de erro:
```json
{
  "timestamp": "2025-10-15T10:30:00",
  "status": 400,
  "error": "Bad Request",
  "message": "Quantidade inválida",
  "path": "/api/trades"
}
```