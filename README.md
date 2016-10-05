# bigdata-examples

Build the Project using ``mvn package``

To work with main classes use ``bigdata-examples-0.0.1-SNAPSHOT.jar``

To work with main classes & dependency jars use ``bigdata-examples-0.0.1-SNAPSHOT-dependency-jars.jar``


# Generate Sample Users using Below Command

usage: help<br>
 -d,--delimiter <arg>       Field Delimiter<br>
 -f,--file <arg>            output file path<br>
 -h,--help                  Show this help and quit<br>
 -n,--numberOfUsers <arg>   number of users<br>
 -s,--startNumber <arg>     starting number of userid, bydefault is 1<br>


#Example1 : To Generate json data, use below command

java -cp target/bigdata-examples-0.0.1-SNAPSHOT-dependency-jars.jar \<br>
com.orienit.kalyan.examples.GenerateUsers \<br>
-f /tmp/users.json \<br>
-n 10 \<br>
-s 1<br>


#Example2 : To Generate csv data, use below command

java -cp target/bigdata-examples-0.0.1-SNAPSHOT-dependency-jars.jar \<br>
com.orienit.kalyan.examples.GenerateUsers \<br>
-f /tmp/users.csv \<br>
-d ',' \<br>
-n 10 \<br>
-s 1<br>


#Example3 : To Generate tsv data, use below command

java -cp target/bigdata-examples-0.0.1-SNAPSHOT-dependency-jars.jar \<br>
com.orienit.kalyan.examples.GenerateUsers \<br>
-f /tmp/users.tsv \<br>
-d '\t' \<br>
-n 10 \<br>
-s 1<br>

#Example4 : To Generate any delimiter data, use below command

java -cp target/bigdata-examples-0.0.1-SNAPSHOT-dependency-jars.jar \<br>
com.orienit.kalyan.examples.GenerateUsers \<br>
-f /tmp/users.txt \<br>
-d '\#' \<br>
-n 10 \<br>
-s 1<br>


# Generate Sample Product Log using Below Command

usage: help<br>
 -d,--delimiter <arg>       Field Delimiter<br>
 -f,--file <arg>            output file path<br>
 -h,--help                  Show this help and quit<br>
 -l,--numberOfLogs <arg>    number of logs<br>
 -n,--numberOfUsers <arg>   number of users<br>

#Example1 : To Generate json data, use below command

java -cp target/bigdata-examples-0.0.1-SNAPSHOT-dependency-jars.jar \<br>
com.orienit.kalyan.examples.GenerateProductLog \<br>
-f /tmp/productlog.json \<br>
-n 10 \<br>
-l 20<br>


#Example2 : To Generate csv data, use below command

java -cp target/bigdata-examples-0.0.1-SNAPSHOT-dependency-jars.jar \<br>
com.orienit.kalyan.examples.GenerateProductLog \<br>
-f /tmp/productlog.csv \<br>
-d ',' \<br>
-n 10 \<br>
-l 20<br>


#Example3 : To Generate tsv data, use below command

java -cp target/bigdata-examples-0.0.1-SNAPSHOT-dependency-jars.jar \<br>
com.orienit.kalyan.examples.GenerateProductLog \<br>
-f /tmp/productlog.tsv \<br>
-d '\t' \<br>
-n 10 \<br>
-l 20<br>


#Example4 : To Generate any delimiter data, use below command

java -cp target/bigdata-examples-0.0.1-SNAPSHOT-dependency-jars.jar \<br>
com.orienit.kalyan.examples.GenerateProductLog \<br>
-f /tmp/productlog.txt \<br>
-d '\#' \<br>
-n 10 \<br>
-l 20<br>



