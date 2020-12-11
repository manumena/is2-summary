Instrucciones para obtener los resultados del taller

1. Guardar el programa en un archivo llamado Exercise1.java
2. Correr javac -g Exercise1.java para generar Exercise1.class, el cual va a ser leido por SOOT
3. Correr java -cp .:soot-3.3.0-jar-with-dependencies.jar:. soot.Main -cp .:\$JRE -f J Exercise1 -print-tags -p jap.rdtagger enabled:true -p jb use-original-names:true -p jb.cp off -keep-line-number, esto genera el output de SOOT con el análisis pedido.

Esas fueron las instrucciones para el primer ejercicio. Para el resto se debe hacer lo mismo pero cambiando jap.rdtagger por jap.lvtagger y jap.npc, según corresponda.
