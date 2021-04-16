# Desafios aritméticos em C#

### (1/3) [Média 1](https://github.com/PFLOA/everis-FullStack/blob/main/Desafios/Introdu%C3%A7%C3%A3o%20a%20Programa%C3%A7%C3%A3o/dividindo_x_por_y.js)

Leia 2 valores de ponto flutuante de dupla precisão A e B, que correspondem a 2 notas de um aluno. A seguir, calcule a média do aluno, sabendo que a nota A tem peso 3.5 e a nota B tem peso 7.5 (A soma dos pesos portanto é 11). Assuma que cada nota pode ir de 0 até 10.0, sempre com uma casa decimal.

**Entrada**

O arquivo de entrada contém 2 valores com uma casa decimal cada um.

**Saída**

Calcule e imprima a variável MEDIA conforme exemplo abaixo, com 5 dígitos após o ponto decimal e com um espaço em branco antes e depois da igualdade. Utilize variáveis de dupla precisão (double) e como todos os problemas, não esqueça de imprimir o fim de linha após o resultado, caso contrário, você receberá "Presentation Error".

| Exemplos de entrada        | Exemplos de saída |
|:----------------------------:|:-----------------:|
| 5.0</br>7.1 |        MEDIA = 6.43182|

| Exemplos de entrada        | Exemplos de saída |
|:----------------------------:|:-----------------:|
| 0.0</br>7.1 |        MEDIA = 4.84091|

| Exemplos de entrada        | Exemplos de saída |
|:----------------------------:|:-----------------:|
| 10.0</br>10.0 |        MEDIA = 10.00000|

### (1/3) [Crescimento Populacional](https://github.com/PFLOA/everis-FullStack/blob/main/Desafios/Introdu%C3%A7%C3%A3o%20a%20Programa%C3%A7%C3%A3o/dividindo_x_por_y.js)

O Governador do Estado quer saber sobre as taxas de crescimento das cidades. De acordo com dados da população e a taxa de crescimento de duas cidades quaisquer (A e B), ele quer que você calcule quantos anos levará para que a cidade menor (A) cresça mais em população que a cidade maior (B).

Claro que o Governador quer saber apenas para as cidades cuja taxa de crescimento da cidade A é maior do que a taxa de crescimento da cidade B, portanto, previamente já separou para você apenas os casos de teste que tem a taxa de crescimento maior para a cidade A.

Desenvolva um programa que apresente o tempo, em anos, para cada caso.

Porém, em alguns casos o tempo pode ser muito grande, e o Governador não se interessa em saber exatamente o tempo para estes casos, já que ele pode não estar mais eleito. Basta que você informe, nesta situação, a mensagem "Mais de 1 século.".

**Entrada**

A primeira linha da entrada contém um único inteiro T, indicando o número de casos de teste (1 ≤ T ≤ 3000). Cada caso de teste contém 4 números: dois inteiros PA e PB (100 ≤ PA < 1000000, PA < PB ≤ 1000000) indicando respectivamente a população de A e B, e dois valores G1 e G2 (0.1 ≤ G1 ≤ 10.0, 0.0 ≤ G2 ≤ 10.0, G2 < G1) com um digito após o ponto decimal cada, indicando respectivamente o crescimento populacional de A e B (em percentual).

Atenção: A população é sempre um valor inteiro, portanto, um crescimento de 2.5 % sobre uma população de 100 pessoas resultará em 102 pessoas, e não 102.5 pessoas, enquanto um crescimento de 2.5% sobre uma população de 1000 pessoas resultará em 1025 pessoas. Além disso, não utilize variáveis de precisão simples para as taxas de crescimento.

**Saída**

Imprima, para cada caso de teste, quantos anos levará para que a cidade A ultrapasse a cidade B em número de habitantes. Obs.: se o tempo for mais do que 100 anos o programa deve apresentar a mensagem: Mais de 1 seculo. Neste caso, é melhor interromper o programa imediatamente após passar de 100 anos, caso contrário você poderá receber como resposta da submissão deste problema "Time Limit Exceeded".

| Exemplos de entrada        | Exemplos de saída |
|:--------------------------:|:-----------------:|
| 6</br>100 150 1.0 0<br>90000 120000 5.5 3.5<br>56700 120000 5.5 3.5<br>56700 72000 5.2 3.0<br><123 2000 3.0 2.0<br>100000 110000 1.5 0.5<br>62422 484317 3.1 1.0|51 anos.<br>16 anos.<br>12 asnos.<br>Mais de 1 seculo.<br>10 anos.<br>100 anos.|


