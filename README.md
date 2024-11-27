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
    "cpf": "987.654.321-00",
    "telefon": "(61) 9 9876-5432",
    "endereco": "Quadra 01 Casa 01",
}
```

| Descrição                           |
| :---------------------------------- |
 **Dados do Cliente feitos em JSON** |

<h3>2. Atualizar os dados de um cliente</h3>

  ```http
  PUT /clientes/:id
```

  ```json
{
    "nome": "Cliclano",
    "cpf": "789.654.321-00",
    "telefon": "(61) 9 8765-5432",
    "endereco": "Quadra 02 Casa 02",
}
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `id`      | `long` ou `UUID` | **Atualiza o nome ou qualquer outro dado do Cliente cujo ID foi passado**. |

<!-- • Permitir editar qualquer dado de um cliente já cadastrado. -->

<h3>3. Deletar um cliente</h3>


  ```http
  DELETE /clientes/:id
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `id`      | `long` ou `UUID` | **Deleta o Cliente do ID que foi passado**. |

<!-- • Remover o cliente e seus veículos associados. -->

<h3>4. Buscar um cliente</h3>

  ```http
  GET /clientes/:id
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `id`      | `long` ou `UUID` | **Retorna o cliente do ID que foi passado**. |


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
    "placa": "A0800",
    "preco": 700

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
    "placa": "B0900",
    "preco": 700

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
    "total" : 1400,
    "items" : [
        {
            "veiculo": 1,
            "quantidade" : 2
        }
    ]
}
```


<h3>Extras :</h3>

• Cadastro e gerenciamento de veículos para cada cliente:

• Dados do veículo: Marca, Modelo e Placa.

• Validação de CPF e CNPJ no momento do cadastro.


  </div>
</div>
