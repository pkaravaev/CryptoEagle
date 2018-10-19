# CryptoEagle

A project on  Spring Framework on the crypto world, which provides data on the coins , news, events , white list.With user authentication  and authorization.

<p align="left">
  <img src="https://travis-ci.org/pkaravaev/CryptoEagle.svg?branch=master" width="120" title="hover text">
</p>

<p align="left">
  <img src="https://codecov.io/gh/pkaravaev/CryptoEagle/branch/master/graph/badge.svg" width="120"  "title="hover text">
</p>


# Frameworks and Tools

* HTML, CSS, Bootstrap, jQuery
* Spring (MVC,Security,Test)
* Jpa(Hibernate)
* JSP, JSTL
* Maven
* Jackson
* PostgreSQL , HSQLDB
* REST
* JUnit, Hamcrest
* SLF4J

# CryptoEagle video

[![Alt text](https://sharryhong.github.io/image/spring.png)](https://www.youtube.com/watch?v=R5fR_unJa7U)


## REST endpoints
#### Get all coins
```
GET /api/coins/
```
#### Get coins by name
```
GET /api/coins/${name}
```

#### Get all blogs
```
GET /api/blogs/
```

#### Get all events
```
GET /api/events/
```

#### Get get items
```
GET /api/items/
```
#### Get get items by source
```
GET /api/items/${source}
```
#### Get get all icos
```
GET /api/icos/
```

#### Get get  ico by name
```
GET /api/icos/${name}
```

#### Get get  icos by status active/upcoming/finished
```
GET /api/icos/${status}
```
