ESCUELA POLIT�CNICA NACIONAL
Autores:
1. Diego P�rez
2. Hern�n Ordo�ez
3. Andr�s Cevallos

--------------------------------------------------------------------------------------------

PROCESO:
El presente proyecto busca construir un modelo en base a machine learning que sea capaz de predecir sentimientos de comentarios realizados por personas. Para ello se han utilizado t�cnicas de an�lisis de lenguaje natural y algoritmos de clasificaci�n tales como NaiveBayes y J48.

El proceso consiste en los siguientes pasos:
1. Captura de datos: En este proyecto se tomo datasets de ejemplo de comentarios de pel�culas tanto de oraciones negativas y positivas. Se trabaj� con 7086 comentarios.

2. Preprocesamiento de datos: A estos comentarios se los clasific� con polaridad negativa y positiva seg�n su contexto. Despu�s se preprocesaron los mismos, quitando espacios en blanco, signos de puntuaci�n, y convirtiendo todas las palabras a letras min�sculas.

Despu�s, mediante un script escrito por los autores en Java, junto con las clases de RiTA (NLTK) se separ� cada palabra dependiendo su funci�n en el comentario. Por ejemplo Bueno->Adjetivo, Like->Verbo, etc. Despu�s se arm� el modelo adecuado.

3.Construcci�n del modelo: La construcci�n del modelo se bas� en base a la intuici�n, para ello se analiz� diversos casos y oraciones dejando el modelo definitivo con los siguientes atributos:
- adj_1: Se refiere al primer adjetivo de la oraci�n. Usualmente positivo
- adj_2: Se refiere al segundo adjetivo de la oraci�n. Usualmente negativo
- verb_1: Se refiere al primer verbo de la oraci�n. Usualmente positivo
- verb_2: Se refiere al segundo verbo de la oraci�n. Usualmente negativo
- negation: Se refiere a si existe o no una negaci�n en la oraci�n
- connector: Se refiere a conectores que pueden alterar el sentido de la oraci�n. Por ejemplo "but"

Se defini� una clase, que en este caso ser�a la polaridad del comentario, si es negativa o positiva.

4. Se gener� un csv de los datos preprocesados seg�n el modelo mediante el script en Java. El mismo que lo transformamos a .arff mediante la siguiente l�nea de comandos de weka: 


5. Se entren� en Weka el modelo con estas instancias. Y se gener� un .arff de pruebas del modelo con 4 nuevas instancias logrando el 100% de predicciones.
Estas oraciones fueron:
I love The Lion King
Transformers is a terrible movie
Jlo is a bad actress 
The photography of SuckerPunch is excellent but actors sucked

----------------------------------------------------------------------------------------------

PREGUNTAS

1. �Cu�ndo se alcanza la mejor precisi�n?
Cuando se poseen un gran n�mero de instancias de entrenamiento, correctamente clasificadas mediante el criterio humano. Adem�s el n�mero de instancias de cada clase debe al menos ser igual para evitar sobreajuste. Lo �ptimo ser�a un 60% para negativas y un 40% de positivas, pues en general los comentarios en su mayor�a son negativos.

�Es importante el n�mero de atributos (features) en el clasificador?
Si, puesto que mientras m�s atributos se tenga, mayor precisi�n se tendr� en predicciones futuras, y mayor datos se tendr�n en el dataset de aprendizaje. En nuestro caso, experimentamos con los atributos anteriormente descritos, y con otro sin conectores y negaciones. En este segundo caso si bien es cierto mejoraba la precisi�n con datos conocidos (95.64%), resultaba pobre en las predicciones nuevas. 

�Es importante el n�mero de instancias?.  
Es importante puesto que se incrementaran la cantidad de combinaciones que podr�a aprender y usar para futuras predicciones.

�En qu� casos?
En los casos que se tenga varios atributos y se necesiten mas combinaciones de los datos de entrenamiento.


�Es importante considerar diferentes pesos para cada atributo?�por qu�?
Si, puesto que de esta forma se evita el sobreajuste. Cada atributo dependiendo del idioma en el cual se est�n analizando los comentarios tienen distintas interpretaciones. Por ello se deber�a dar m�s peso a los adjetivos negativos, puesto que siempre opacar�n a los positivos.


�Est� su modelo sobreajustado �overfitted�?
Actualmente el modelo presenta un leve sobreajuste en algunos casos, seria necesario unificar verbos para que estos tengan un peso mas equilibrado.
Para disminuir el sobreajuste se eliminaron todos los datos duplicados que pueden sesgar la predicci�n de un comentario. Puesto que antes de quitar duplicados, nuestro modelo estar�a sobreajustado puesto que exist�an demasiadas instancias que daban mucho m�s peso a ciertas palabras. Al borrar duplicados el n�mero de palabras se equilibr� por tanto los pesos tambi�n. 

�Los atributos cont�nuos son mejores o peores en el clasificador Naive Bayes?
No, porque si existen atributos muy diferentes pudieran no tener el peso necesario para influiro pudieran cesgar el conjunto de datos.

Comparar los diferentes algoritmos con su conjunto de datos y determinar cu�l de ellos es el que mejor
          Correct Incorrect
BayesNet:    89  -  10
NaiveBayes:  80  -  19
J48: 	     51  -  48
Part:        51  -  48
ZeroR:       51  -  48

Par nuestro modelo el mejor algoritmo es BayesNet.

�Es mejor utilizar validaci�n cruzada (cross-validation) o un test dataset para realizar la evaluaci�n del clasificardor? �Por qu�?
Hay que utiliza las dos. El Cross-validation para la creacion del modelo y ver la interacci�n de los atributos y la precisi�n del modelo. El dataset test nos ayuda a verificar el funcionamiento real del modelo y encontrar errores en nuestro conjunto entrenado.

--------------------------------------------------------------------------------------------

CONCLUSIONES:

1. Evitar duplicados puesto que pueden crear sobreajuste.
2. Es necesario usar una forma normalizada en los verbos, puesto que pueden tener el mismo concepto pero ya no tienen el mismo peso.
3. Es necesario realizar pruebas con los atributos para saber si significan algo en el modelo. En nuestro caso probamos con diferentes atributos, resultando �ptimo el que actualmente tenemos.

------------------------------------------------------------------------------------------

INSTALACI�N:
1. Descomprimir el proyecto java.
2. Importar el proyecto java y ejecutarlo.
3. Una vez se tenga el csv resultante se debe ejecutar en la l�nea de comandos la siguiente l�nea para generar el arff java -cp weka.jar weka.core.converters.CSVLoader model_4.csv > model_4.arff
4. Abrir Weka, y abrir el archivo.
5. Disfrutar.