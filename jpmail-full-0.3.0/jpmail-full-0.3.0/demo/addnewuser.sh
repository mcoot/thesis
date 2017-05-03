#!/bin/sh
mkdir certs-$1
cd certs-$1
# make a new keystore for the new user
#keytool -genkey -keyalg RSA -keystore .keystore -storepass $2 -keypass $2 -alias $1 -dname "CN=$1, OU=JPmail Lab, O=JPmail, L=Home, ST=PA, C=US"
keytool -genkey -keyalg RSA -keystore .keystore -storepass $2 -alias $1 -dname "CN=$1, OU=JPmail Lab, O=JPmail, L=Home, ST=PA, C=US"
# get CA certificate and import into keystore as trusted CA
cp ../demoCA/cacert.pem .
keytool -import -keystore .keystore -storepass $2 -alias demoCA -file cacert.pem

# generate a certificate signing request
keytool -certreq -keystore .keystore -storepass $2 -alias $1 -file $1CSR.pem

# get it signed
cp $1CSR.pem ../demoCA/newcerts

# "become" the CA and sign it (use password "jpmail") 
cd ../demoCA
openssl ca -config openssl.cnf -in newcerts/$1CSR.pem -out certs/$1Cert.pem -keyfile private/cakey.pem -cert cacert.pem
# convert it to a DER file (for ease of use with keystore)
openssl x509 -in certs/$1Cert.pem -out certs/$1Cert.der -outform DER
# "return" the signed certificates to the user
cp certs/$1Cert.pem ../certs-$1
cp certs/$1Cert.der ../certs-$1

# user checks signed certificate back into keytool:
cd ../certs-$1
keytool -import -keystore .keystore -alias $1 -storepass $2 -file $1Cert.der

