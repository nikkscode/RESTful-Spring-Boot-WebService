# RESTful-Spring-Boot-WebService

## Description:
This application is created for demo purposes, but should also serve in the future as a template for other RESTful Webservices.

## Specs:
This RESTful Webservice consists auf two entities: Users and their Posts
- A User can apply basic functions like creating and deleting Posts.
- A Post has a short description and holds information about its creator.
###1. User
####1.1 User Bean

| User                   |
|------------------------|
| private Integer: id    |
| private String: name   |
| private Date: birthday |

####1.2 User-Controller

| Function           | Request Method | URI         | Example  |
|--------------------|----------------|-------------|----------|
| Retrieve all Users | GET            | /users      |          |
| Create a User      | POST           | /users      |          |
| Retrieve one User  | GET            | /users{id}  | /users/1 |
| Delete a User      | DELETE         | /users{id}  | /users/1 |

### 2. Posts
#### 2.1. Post Bean

| Post                        |
|-----------------------------|
| private Integer: id         |
| private String: description |
| private User: user          |

#### 2.2 Posts-Controller

| Function                      | Request Method | URI                         | Example            |
|-------------------------------|----------------|-----------------------------|--------------------|
| Retrieve all posts for a User | GET            | /users/{id}/posts           | /users/1/posts     |
| Create a post for a User      | POST           | /users/{id}/posts           | /users/1/posts     |
| Retrieve defails of a post    | GET            | /users/{id}/posts/{post_id} | /users/1/posts/210 |