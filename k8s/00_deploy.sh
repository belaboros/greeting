kubectl apply -f greeting-deployment.yml

kubectl get all

kubectl describe service greeting



echo -e "\n\n\nQuery Greeting service:"
wget -qO- $(kubectl get services | grep greeting | tr -s ' ' | cut -d ' ' -f 3,5 --output-delimiter ':' | cut -d '/' -f 1)/api/greet1