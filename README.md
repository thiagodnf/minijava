<img src="https://raw.githubusercontent.com/thiagodnf/minijava/master/src/main/resources/images/name.png" />

MiniJava Compiler Powered by JavaFX


# Description

Como trabalho final da disciplina de Compiladores, foi desenvolvido um compilador para a linguagem MiniJava utilizando algumas ferramentas como o JFLEX e o CUP para fazer o parseamento do código. Para facilitar o acesso do desenvolvedor a linguagem, foi desenvolvido uma pequena IDE para ter agilidade na escrita e compilação do código.

# Screenshot

<img src="https://raw.githubusercontent.com/thiagodnf/minijava/master/src/main/resources/images/screenshot.png" />

# Team
- Débora Martins
- Thiago Nascimento

Como usar:
-----------
1. Baixe o arquivo `MiniJava.jar` disponibilizado na pasta "jar" do projeto.
    - Linux:
        - Compilar via console `java -jar MiniJava.jar -c -d PATH`
        - Executar interface gráfica `java -jar MiniJava.jar -gui`
        - Abrir arquivo na interface gráfica `java -jar MiniJava.jar -gui -d PATH`        

# Compile 

```sh
mvn clean compile jfx:jar jfx:native
```

ChangeLog:
-----------
- Versão 1.0
    - Inserido a Análise Léxica.
    - Adicionado a interface gráfica para edição e compilação.
    - Adicionado a opção de compilar o código via terminal.
    

