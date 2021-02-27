This is <B>OnlineBook</B> Shop project which is implemented in <B>Spring Boot</B> in backend and <B>Angular 8</B> in front end.



kubectl create configmap offersdata-configmap --from-literal=OFFERS_DATA_FILE_PATH=/etc/offerdata/offerRule.csv
kubectl create secret generic offerdata-data --from-file offerRule.csv