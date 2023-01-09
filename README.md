# ProductManagementBE
This project consists of two applications: one is a Spring Boot Rest API and another is a ReactJS application. <br />Frontend repo [here](https://github.com/Aysenur-Tuncer/ProductManagementFE). <br /><br />
## Applications
<br />
Spring-backend:
<br />
Spring Boot Web Java backend application that exposes a REST API to manage products. Its secured endpoints can just be accessed if an access token (JWT) is provided.
<br />
spring-backend stores its data in a PostgreSQL database.
<br />
<br />
react-frontend:
<br />
ReactJS frontend application where users can save product and manage stock of products. In order to access the application, user must login using his/her email and password. All the requests coming from react-frontend to secured endpoints in spring-backend have a access token (JWT) that is generated when user logs in.
<br />

## Clone the repository:
```
git clone https://github.com/Aysenur-Tuncer/ProductManagementBE.git
```


 
