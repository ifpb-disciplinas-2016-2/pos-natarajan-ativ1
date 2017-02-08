# Passo-a-passo

As etapas a seguir foram realizadas com base no artigo criado por  Rayfran Rocha Lima e modificado por Radams Venceslau intitulado "Criando um HelloWorld usando Java/Corba"

### 1. Criando e compilando uma Interface IDL

1. na pasta principal do nosso projeto, criamos um arquivo `Hello.idl`. O mesmo é responsável por especificar a interface que expõe os métodos que deverão ser implementados em Corba (no nosso caso os métodos `sayhello` e `oneway` ).

2. na mesma pasta, realizamos o comando `idlj –fall Hello.idl`. O `idlj` do Java SE mapeia a interface idl em arquivos Java que seguem a especificação do Corba, criando a pasta `hello` e inserido arquivos na mesma.

### 2. Criando as implementações da interface Java criada pelo idl

1. Criamos o pacote `helloserver` e dentro dele a classe `HelloImpl`, implementando HelloPOA;

2. Ainda no pacote `helloserver` criamos a classe `HelloServer` que será responsável por instanciar um objeto `HelloImpl` e disponibiliza-lo através de ORB (Object Request Broker).

3. Em seguida, crimaos o pacote `hellocliente` contendo a classe `HelloClient`. Esta última, quando executada, procura o object request broker e tenta resolver um objeto Hello, em seguida chamando o método `sayhello`.


### Execução

* Ao limpar e construir o projeto, será criada a subpasta no caminho `pasta-do-projeto/build/classes` onde se encontram os arquivos `.class`.

* Entrar nessa pasta e realizar os passos:

  * executar o comando

    `orbd -ORBInitialPort 1050 -ORBInitialHost localhost`

  * ainda dentro de `build/classes` executar o servidor com

    `java  helloserver.HelloServer -ORBInitialPort 1050 -ORBInitialHost localhost
`
  * executar o cliente com

    `java helloclient.HelloClient -ORBInitialPort 1050 -ORBInitialHost localhost`
No lado do servidor deve aparecer uma mensagem como:

`HelloServer ready and waiting ...
IOR:000000000000001449444c3a68656c6c6f2f48656c6c6f3a312e3000000000010000000000000086000102000000000e3139322e3136382e34332e343200e17700000031afabcb00000000201a18147500000001000000000000000100000008526f6f74504f410000000008000000010000000014000000000000020000000100000020000000000001000100000002050100010001002000010109000000010001010000000026000000020002
HelloServer Exiting ...
`

  e no lado do cliente:

`Obtained a handle on server object: IOR:000000000000001449444c3a68656c6c6f2f48656c6c6f3a312e3000000000010000000000000086000102000000000e3139322e3136382e34332e343200e17700000031afabcb00000000201a18147500000001000000000000000100000008526f6f74504f410000000008000000010000000014000000000000020000000100000020000000000001000100000002050100010001002000010109000000010001010000000026000000020002
Hello world !!`
