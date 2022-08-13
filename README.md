# RESTful-Spring-Boot-WebService

## 1. Description
This application is created for demo purposes, but should also serve in the future as a template for other RESTful Webservices.

## 2. Build and Run
This WebService was build with the Gradle Build-Tool. \
### 2.1. Build project 
When you have gradle installed on your local machine run:\
```$ gradle clean build```\
Alternatively build with the Gradle Wrapper: \
``` $ ./gradlew clean build```
### 2.2. Run Application
``` $ gradle bootrun ``` or ``` $ ./gradlew bootrun ```

## 3. Basic Authentication of this WebService
In order to use this WebService a login is needed.
```
Username: username
Password: password
```

## 4. Documentation OAS3 Standard
In order to read the whole OAS-Specification go to:
```
http://localhost:8080/swagger-ui/index.html
```

## 5. Specs
This RESTful Webservice consists auf two entities: Users and their Posts
- A User can apply basic functions like creating and deleting Posts.
- A Post has a short description and holds information about its creator.
### 5.1. User
#### 5.1.1. User Bean

| User                   |
|------------------------|
| private Integer: id    |
| private String: name   |
| private Date: birthday |

#### 5.1.2. User-Controller

| Function           | Request Method | URI         | Example  |
|--------------------|----------------|-------------|----------|
| Retrieve all Users | GET            | /users      |          |
| Create a User      | POST           | /users      |          |
| Retrieve one User  | GET            | /users{id}  | /users/1 |
| Delete a User      | DELETE         | /users{id}  | /users/1 |

### 5.2. Posts
#### 5.2.1. Post Bean

| Post                        |
|-----------------------------|
| private Integer: id         |
| private String: description |
| private User: user          |

#### 5.2.2. Posts-Controller

| Function                      | Request Method | URI                         | Example            |
|-------------------------------|----------------|-----------------------------|--------------------|
| Retrieve all posts for a User | GET            | /users/{id}/posts           | /users/1/posts     |
| Create a post for a User      | POST           | /users/{id}/posts           | /users/1/posts     |
| Retrieve defails of a post    | GET            | /users/{id}/posts/{post_id} | /users/1/posts/210 |



