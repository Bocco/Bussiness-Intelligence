ESCUELA POLITÉCNICA NACIONAL
Autores:
1. Diego Pérez
2. Hernán Ordoñez
3. Andrés Cevallos

--------------------------------------------------------------------------------------------

PROCESO:
El presente proyecto busca construir un modelo en base a machine learning que sea capaz de predecir sentimientos de comentarios realizados por personas. Para ello se han utilizado técnicas de análisis de lenguaje natural y algoritmos de clasificación tales como NaiveBayes y J48.

El proceso consiste en los siguientes pasos:
1. Captura de datos: En este proyecto se tomo datasets de ejemplo de comentarios de películas tanto de oraciones negativas y positivas. Se trabajó con 7086 comentarios.

2. Preprocesamiento de datos: A estos comentarios se los clasificó con polaridad negativa y positiva según su contexto. Después se preprocesaron los mismos, quitando espacios en blanco, signos de puntuación, y convirtiendo todas las palabras a letras minúsculas.

Después, mediante un script escrito por los autores en Java, junto con las clases de RiTA (NLTK) se separó cada palabra dependiendo su función en el comentario. Por ejemplo Bueno->Adjetivo, Like->Verbo, etc. Después se armó el modelo adecuado.

3.Construcción del modelo: La construcción del modelo se basó en base a la intuición, para ello se analizó diversos casos y oraciones dejando el modelo definitivo con los siguientes atributos:
- adj_1: Se refiere al primer adjetivo de la oración. Usualmente positivo
- adj_2: Se refiere al segundo adjetivo de la oración. Usualmente negativo
- verb_1: Se refiere al primer verbo de la oración. Usualmente positivo
- verb_2: Se refiere al segundo verbo de la oración. Usualmente negativo
- negation: Se refiere a si existe o no una negación en la oración
- connector: Se refiere a conectores que pueden alterar el sentido de la oración. Por ejemplo "but"

Se definió una clase, que en este caso sería la polaridad del comentario, si es negativa o positiva.

4. Se generó un csv de los datos preprocesados según el modelo mediante el script en Java. El mismo que lo transformamos a .arff mediante la siguiente línea de comandos de weka: 


5. Se entrenó en Weka el modelo con estas instancias. Y se generó un .arff de pruebas del modelo con 4 nuevas instancias logrando el 100% de predicciones.
Estas oraciones fueron:
I love The Lion King
Transformers is a terrible movie
Jlo is a bad actress 
The photography of SuckerPunch is excellent but actors sucked

----------------------------------------------------------------------------------------------

PREGUNTAS

1. ¿Cuándo se alcanza la mejor precisión?
Cuando se poseen un gran número de instancias de entrenamiento, correctamente clasificadas mediante el criterio humano. Además el número de instancias de cada clase debe al menos ser igual para evitar sobreajuste. Lo óptimo sería un 60% para negativas y un 40% de positivas, pues en general los comentarios en su mayoría son negativos.

¿Es importante el número de atributos (features) en el clasificador?
Si, puesto que mientras más atributos se tenga, mayor precisión se tendrá en predicciones futuras, y mayor datos se tendrán en el dataset de aprendizaje. En nuestro caso, experimentamos con los atributos anteriormente descritos, y con otro sin conectores y negaciones. En este segundo caso si bien es cierto mejoraba la precisión con datos conocidos (95.64%), resultaba pobre en las predicciones nuevas. 

¿Es importante el número de instancias?.  
Es importante puesto que se incrementaran la cantidad de combinaciones que podría aprender y usar para futuras predicciones.

¿En qué casos?
En los casos que se tenga varios atributos y se necesiten mas combinaciones de los datos de entrenamiento.


¿Es importante considerar diferentes pesos para cada atributo?¿por qué?
Si, puesto que de esta forma se evita el sobreajuste. Cada atributo dependiendo del idioma en el cual se están analizando los comentarios tienen distintas interpretaciones. Por ello se debería dar más peso a los adjetivos negativos, puesto que siempre opacarán a los positivos.


¿Está su modelo sobreajustado “overfitted”?
Actualmente el modelo presenta un leve sobreajuste en algunos casos, seria necesario unificar verbos para que estos tengan un peso mas equilibrado.
Para disminuir el sobreajuste se eliminaron todos los datos duplicados que pueden sesgar la predicción de un comentario. Puesto que antes de quitar duplicados, nuestro modelo estarìa sobreajustado puesto que existían demasiadas instancias que daban mucho más peso a ciertas palabras. Al borrar duplicados el número de palabras se equilibró por tanto los pesos también. 

¿Los atributos contínuos son mejores o peores en el clasificador Naive Bayes?
No, porque si existen atributos muy diferentes pudieran no tener el peso necesario para influiro pudieran cesgar el conjunto de datos.

Comparar los diferentes algoritmos con su conjunto de datos y determinar cuál de ellos es el que mejor
          Correct Incorrect
BayesNet:    89  -  10
NaiveBayes:  80  -  19
J48: 	     51  -  48
Part:        51  -  48
ZeroR:       51  -  48

Par nuestro modelo el mejor algoritmo es BayesNet.

¿Es mejor utilizar validación cruzada (cross-validation) o un test dataset para realizar la evaluación del clasificardor? ¿Por qué?
Hay que utiliza las dos. El Cross-validation para la creacion del modelo y ver la interacción de los atributos y la precisión del modelo. El dataset test nos ayuda a verificar el funcionamiento real del modelo y encontrar errores en nuestro conjunto entrenado.

--------------------------------------------------------------------------------------------

CONCLUSIONES:

1. Evitar duplicados puesto que pueden crear sobreajuste.
2. Es necesario usar una forma normalizada en los verbos, puesto que pueden tener el mismo concepto pero ya no tienen el mismo peso.
3. Es necesario realizar pruebas con los atributos para saber si significan algo en el modelo. En nuestro caso probamos con diferentes atributos, resultando óptimo el que actualmente tenemos.

------------------------------------------------------------------------------------------

INSTALACIÓN:
1. Descomprimir el proyecto java.
2. Importar el proyecto java y ejecutarlo.
3. Una vez se tenga el csv resultante se debe ejecutar en la línea de comandos la siguiente línea para generar el arff java -cp weka.jar weka.core.converters.CSVLoader model_4.csv > model_4.arff
4. Abrir Weka, y abrir el archivo.
5. Disfrutar.