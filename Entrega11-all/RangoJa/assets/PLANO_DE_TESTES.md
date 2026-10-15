# Plano de testes — RangoJá

Os valores monetários são comparados com tolerância de `0.001`, conforme o PDF. As exceções esperadas são verificadas com `assertThrows`.

| Classe | Caso / descrição | Entrada | Saída esperada |
|---|---|---|---|
| ClienteTest | Idade negativa | idade `-1` | `IllegalArgumentException` |
| ClienteTest | E-mail sem `@` | `ana.furb.br` | `IllegalArgumentException` |
| ClienteTest | Indicação | Beto criado com Ana como indicadora | saldo de Ana = R$ 10,00 |
| ClienteTest | Saldo insuficiente | saldo R$ 10,00; uso R$ 15,00 | `SaldoInsuficienteException` |
| ClienteTest | E-mails com caixa diferente | `ana@furb.br`, `ANA@FURB.BR` | `equals` verdadeiro |
| ClienteTest | Nome vazio | nome em branco | `IllegalArgumentException` |
| ClienteTest | Setter de idade inválida | `setIdade(121)` | `IllegalArgumentException` |
| ClienteTest | Uso válido de cashback | saldo 12; uso 5 | `true`, saldo R$ 7,00 |
| ClienteTest | Indicador nulo | construtor com indicador `null` | `IllegalArgumentException` |
| ItemCardapioTest | Setter de preço inválido | `setPrecoBase(0)` | exceção; preço anterior mantido |
| ItemCardapioTest | Nome obrigatório | nome em branco | `IllegalArgumentException` |
| ItemCardapioTest | Desconto máximo | desconto 100% | preço final zero |
| PratoTest | Tamanho inválido | tamanho `X` | `IllegalArgumentException` |
| PratoTest | Desconto promocional | preço base 30, tamanho M, desconto 10% | R$ 35,10 |
| PratoTest | Desconto acima do limite | 120% | `IllegalArgumentException` |
| PratoTest | Tamanho P | base R$ 30, tamanho P | R$ 30,00 |
| PratoTest | Tamanho G | base R$ 30, tamanho G | R$ 48,00 |
| PratoTest | Preço base zero | base R$ 0,00 | `IllegalArgumentException` |
| BebidaTest | Chopp alcoólico | base 12, 500 ml, alcoólico | R$ 15,00 |
| BebidaTest | Volume zero | 0 ml | `IllegalArgumentException` |
| BebidaTest | Bebida não alcoólica | base R$ 6,00 | R$ 6,00 |
| BebidaTest | Texto de bebida | Chopp 500 ml | texto contém volume e `[alcoólica]` |
| SobremesaTest | Preço proporcional | R$ 8 por 100 g; peso 150 g | R$ 12,00 |
| SobremesaTest | Peso zero | 0 g | `IllegalArgumentException` |
| SobremesaTest | Peso negativo | -10 g | `IllegalArgumentException` |
| SobremesaTest | Texto de sobremesa | pudim 150 g | texto contém `150 g` |
| PedidoTest | Subtotal e taxa | Xis M + refri + pudim | subtotal R$ 57,00; taxa R$ 7,00; total R$ 64,00 |
| PedidoTest | Frete grátis | dois pratos G de base R$ 40,00 | total R$ 128,00; taxa zero |
| PedidoTest | Menor de idade e chopp | Beto, 17 anos | `IllegalArgumentException` |
| PedidoTest | Quantidade zero | quantidade `0` | `IllegalArgumentException` |
| PedidoTest | Finalizar sem itens | pedido vazio | `IllegalStateException` |
| PedidoTest | Cashback ao finalizar | subtotal R$ 57,00 | saldo aumenta R$ 2,85 |
| PedidoTest | Numeração sequencial | criar dois pedidos | segundo número = primeiro + 1 |
| PedidoTest | Cliente nulo | `new Pedido(null)` | `IllegalArgumentException` |
| PedidoTest | Item nulo | `adicionarItem(null)` | `IllegalArgumentException` |
| PedidoTest | Alterar pedido finalizado | adicionar depois de finalizar | `IllegalStateException` |
| AssinaturaClubeTest | Plano anual | R$ 19,90 por 12 meses | R$ 202,98 |
| AssinaturaClubeTest | Plano de 11 meses | R$ 19,90 por 11 meses | R$ 218,90 |
| AssinaturaClubeTest | Cliente nulo | cliente `null` | `IllegalArgumentException` |
| AssinaturaClubeTest | Duração zero | 0 meses | `IllegalArgumentException` |
| CentralCobrancaTest | Pedido + assinatura anual | pedido de R$ 64,00 e assinatura de R$ 202,98 | total R$ 266,98 |
| CentralCobrancaTest | Registrar nulo | cobrança `null` | `IllegalArgumentException` |
| CentralCobrancaTest | Relatório | assinatura de R$ 10,00 | comprovante e total no texto |
| CentralCobrancaTest | Central vazia | nenhuma cobrança | total zero |
| CobravelTest | Método default | cobrança de R$ 64,00 | `Valor a cobrar: R$ 64,00` |
| CobravelTest | Pedido como cobrável | pedido que totaliza R$ 64,00 | comprovante de R$ 64,00 |
| SaldoInsuficienteExceptionTest | Mensagem | saldo 4; solicitação 10 | mensagem contém R$ 4,00 e R$ 10,00 |
| SaldoInsuficienteExceptionTest | Tipo verificável | classe da exceção | herda de `Exception` |
