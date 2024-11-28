<div align="center">
  <img src="https://github.com/ralflima/java_spring/blob/master/icone.png" width="30%">

<h1 style="border-bottom:none">Rotas da API</h1>
  <img src="/.github/SpringInitializr.png" width="100%">

##

  <h3 align="center"> CRUD ( clientes ) </h3>

##

  <div align="justify">
  <h3>1. Cadastrar um cliente</h3>

  ```http
  POST /clientes
```

  ```json
{
    "nome": "Fulano",
    "cpf": "123.456.789-75",
    "telefone": "9 9516-7453",
    "endereco": "Casa 01 quadra 01"
}
```

| Descrição                           |
| :---------------------------------- |
 **Dados do cliente feitos em JSON** |

<h3>2. Atualizar os dados de um cliente</h3>

  ```http
  PUT /clientes/:id
```

  ```json
{
    "nome": "Cliclano",
    "cpf": "234.456.789-71",
    "telefone": "8 8516-7453",
    "endereco": "Casa 02 quadra 02"
}
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `id`      | `long` ou `UUID` | **Atualiza o nome ou qualquer outro dado do cliente cujo ID foi passado**. |

<!-- • Permitir editar qualquer dado de um cliente já cadastrado. -->

<h3>3. Deletar um cliente</h3>


  ```http
  DELETE /clientes/:id
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `id`      | `long` ou `UUID` | **Deleta o cliente do ID que foi passado**. |

<!-- • Remover o cliente e seus veículos associados. -->

<h3>4. Buscar um cliente</h3>

  ```http
  GET /clientes/:id
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `id`      | `long` ou `UUID` | **Retorna o cliente do ID que foi passado**. |


<h3>5. Obter detalhes de um ou varios clientes</h3>

  ```http
  GET /clientes?cpf=123.456.789-75
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| Todos      | Todos | **Retorna o cliente respectivo do parametro que foi passado**. |

<!--• • A busca deve ser feita usando CPF (para pessoa física) ou CNPJ (para pessoa jurídica). -->

##

##

##

  <h3 align="center">veiculos</h3>

##

  <div align="justify">
  <h3>1. Cadastrar um veiculo</h3>

  ```http
  POST /veiculos
```

  ```json
{
    "marca": "FIAT",
    "modelo": "Uno Way 1.4 Flex",
    "placa": "A0800"

}
```

| Descrição                           |
| :---------------------------------- |
 **Dados do veiculo feitos em JSON** |

<h3>2. Atualizar os dados de um veiculo</h3>

  ```http
  PUT /veiculos/:id
```

  ```json
{
    "marca": "CHEVROLET",
    "modelo": "Celta Lt 1.O Flex",
    "placa": "B0900"

}
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `id`      | `long` ou `UUID` | **Atualiza o nome ou qualquer outro dado do veiculo cujo ID foi passado**. |


<h3>3. Deletar um veiculo</h3>


  ```http
  DELETE /veiculos/:id
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `id`      | `long` ou `UUID` | **Deleta o veiculo do ID que foi passado**. |


<h3>4. Buscar um veiculo</h3>

  ```http
  GET /veiculos/:id
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `id`      | `long` ou `UUID` | **Retorna o veiculo do ID que foi passado**. |


<h3>5. Obter detalhes de um ou varios veiculos</h3>

  ```http
  GET /veiculos?modelo=Celta
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| Todos      | Todos | **Retorna o veiculo respectivo do parametro que foi passado**. |


##

##

##

  <h3 align="center">  Cadastros</h3>

##

  <div align="justify">
  <h3>1. Cadastrar cliente para cada veiculo</h3>

  ```http
  POST /cadastros
```

  ```json
{
    "cliente" : 1,
    "items" : [
        {
            "veiculo": 1
        }
    ]
}
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `id`      | `long` ou `UUID` | **Cadastra o cliente e veiculo cujo ID foi passado, no qual e o mesmo gerado dos seus respectivos cadastros anteriores**. |

  <div align="justify">
  <h3>2. Obter Detalhes</h3>

  ```http
  GET /cadastros/1
```

  ```json
{
    "codigo": 1,
    "cpf": "234.456.789-71",
    "nomeCliente": "Cliclano",
    "dataCadastro": "28/11/2024",
    "items": [
        {
            "marcaVeiculo": "CHEVROLET"
        }
    ]
}
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `id`      | `long` ou `UUID` | **Retorna o cadastro do ID que foi passado**. |

##

• Validação de CPF e CNPJ no momento do cadastro.


  </div>
</div>
