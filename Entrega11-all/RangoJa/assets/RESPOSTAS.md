# Perguntas para entrega

1. **Por que `proximoNumero` é `static` e `numero` não é?**  
   `proximoNumero` é compartilhado por todos os pedidos e controla a próxima numeração. `numero` pertence a cada objeto, porque cada pedido tem seu próprio número.

2. **Por que `calcularPrecoComDesconto` é `final` e `calcularPreco` é `abstract`? Um método poderia ser os dois?**  
   `calcularPrecoComDesconto` contém uma regra comum que não deve ser alterada pelas subclasses, por isso é `final`. `calcularPreco` precisa ser implementado de maneira diferente por cada tipo de item, por isso é `abstract`. Em Java, um método não pode ser simultaneamente `abstract` e `final`: o primeiro exige implementação na subclasse e o segundo proíbe sobrescrita.

3. **Se a navegação entre `Pedido` e `Cliente` fosse bidirecional, o que mudaria em `Cliente`?**  
   `Cliente` precisaria manter uma coleção de pedidos e métodos para consultar/adicionar pedidos. Ao criar um pedido, os dois lados da associação precisariam ser atualizados.

4. **Por que `usarCashback` precisa de `throws` e `adicionarItem` não precisa, mesmo os dois lançando exceções?**  
   `SaldoInsuficienteException` herda diretamente de `Exception`, então é uma exceção verificável e precisa ser declarada ou tratada. `IllegalArgumentException` e `IllegalStateException` são exceções não verificáveis (`RuntimeException`), então não precisam aparecer em `throws`.
