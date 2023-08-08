# 📖`REST`는 무엇인가?

- 분산 하이퍼 미디어 시스템(`Distributed Hypermedia Systems`)을 위한 소프트웨어 아키텍쳐입니다.
- 효율이고 안정적으로 확장 가능한 분산시스템을 가져올 수 있는 소프트웨어 아키텍처 디자인 제약의 모음을 나타냅니다.
- `HTTP`에서 쿠기나 세션 트랙킹 같은 별도의 전송 계층 없이 전송하기 위한 간단한 인터페이스입니다.

# 📖REST 특징, 원칙, 제약사항

## 1. 🧷균일한 인터페이스 (`Uniform Interface`)
- 리소스에 대한 요청이 HTTP 표준 프로토콜에 따른다면, 특정 언어나 장치, 기술에 종속되지 않습니다.

## 2. 🧷클라이언트-서버 (`Client-Server`)
- 클라이언트와 서버가 서로 간에 독립적이며, 각 역활이 명확하고 서로 간의 의존성이 줄어듭니다.
- 클라이언트는 서버에게 리소스 요청(`requset`)만을 수행하며, 서버는 HTTP를 통해 요청된 데이터를 전달(응답 `response`)하는 것 말고는 클라이언트을 수정하지 않아야 합니다.

## 3. 🧷`Stateless`
- 서버가 클라이언의 세션(`session`)을 보존하지 않음을 의미합니다.
- 서버는 클라이언트 요청과 관련된 데이터를 따로 저장하지 않습니다.
- 따라서, 클라이언트 요청에 서버가 처리에 필요한 모든 정보를 포함해야 합니다.

## 4. 🧷캐싱 가능성 (`Cacheable`)
- HTTP 프로토콜이 가진 캐싱 기능을 적용할 수 있습니다.
- 서버 응답에 전달된 리소스에 대해 캐싱을 허용되는 지 여부에 대한 정보도 포함되어야 합니다.
- 대량의 요청을 효율적으로 처리할 수 있습니다.
- 서버측의 확장성이 증가하고 클라이언트측의 성능 향상을 동시에 얻을 수 있습니다.

## 5. 🧷계층화 시스템 (`Layered System`)

![proxy](img/proxy.jpg)
- 클라이언트는 REST API Server만 호출합니다.
- 클라이언트와 서버 사이 승인된 중개자 서버인 `Proxy`서버를 사용할 수 있습니다.
- 보안, 로드밸런싱, 암호화 등 계층을 추가하여 구조 변경이 가능합니다.
- 서버와 직접 통신하는지, 중개자와 통신하는지 여부를 클라이언트는 알 수 없습니다.

## 6. 🧷자체 표현 구조 (`Self-Descriptive`)
- 메시지만으로 무슨 행위를 하는 지 알 수 있으며, 해당 메세지에 대한 설명이 가능해집니다.

# 📖REST API

- REST 아키텍처 기반으로 시스템을 분산해 확장성과 재사용성을 높여 보수및 운용을 편리하게 할 수 있습니다.
- HTTP를 지원하는 언어로 클라이언트와 서버를 구현할 수 있습니다.
- 주로 js에서 Ajax또는 fetch, jQuery 라이브러리에서 메서드 이용.

# 📖RESTful API 구성 요소

## 자원 - URI

- 서버는 고유한 리소스 식별자로 각 리소스를 식별합니다.
- REST 서비스 경우 서버는 일반적으로 URI을 사용하여 리소스를 식별을 수행합니다.
- 클라이언트가 요구하는 사항을 서버에 명확하게 지정해야합니다.

## 행위 - 메서드
- HTTP 프로토콜의 메서드를 사용한다.
- 각 메서드는 자원에 대한 특정 동작을 나타냅니다.

|메서드|행위|설명|
|---|---|---|
|GET|READ|정보 요청, URI가 가진 정보를 검색하기 위해 서버에 요청한다.|
|POST|Create|정보 입력, 클라이언트에서 서버로 전달하려는 정보를 보낸다.|
|PUT|Update|정보 수정, 전체 내용을 갱신하기 위해 사용한다.|
|PATCH|Update|정보 수정, 일부 내용을 갱신하기 위해 사용한다.|
|DELETE|Delete|정보 삭제, (안정성 문제로 대부분 서버에서 비활성)|

## 자원의 표현 : `*.json`, `*.xml`
- 클라이언트와 서버간 데이터를 주고 받을 때, 리소스에 대한 정보를 `json`, `XML`, `TEXT`, `RSS` 등의 형태로 전달합니다.
- 서버는 클라이언트에 대한 요청을 응답으로 상태코드를 전달합니다.
- 요즘 추세는 Key, Value를 활용한 Json을 많이 사용합니다.

### 상태 전달
- 클라이언트는 서버에게 자원에 대한 상태를 명시적으로 전달하고
-서버는 이 상태에 따라 적절한 응답을 제공합니다

# 📖RESTful의 장단점

## 장점
- HTTP 프로토콜의 인프라를 그대로 사용하므로 REST API 사용을 위한 별도의 인프라를 구출할 필요가 없다.
- HTTP 프로토콜의 표준을 최대한 활용하여 여러 추가적인 장점을 함께 가져갈 수있게 해준다.
- HTTP 표준 프로토콜에 따르는 모든 플랫폼에서 사용이 가능하다.
- Hypermedia API의 기본을 충실히 지키면서 범용성을 보장한다.
- REST API 메시지가 의도하는 바를 명확하게 나타내므로 의도하는 바를 쉽게 파악할 수 있다.
- 여러 가지 서비스 디자인에서 생길 수 있는 문제를 최소화한다.
- 서버와 클라이언트의 역할을 명확하게 분리한다.

## 단점
- HTTP 프로토콜만 사용해야 한다.
- 표준이 없기 때문에 관리가 어렵고, 이러한 부분까지 고려해서 구현할 경우 설계나 구현에서 어려움을 갖는다.

# `URI` 명명규칙

## 1. ✍️리소스는 명사를 사용해서 표현한다.
```
✅http://example.com/users
✅http://example.com/topics
```

## 2. ✍️단어간 구분은 하이픈(`-`)를 사용한다.
```
🚫http://example.com/userManagement
// 대문자 사용
🚫http://example.com/user_management
// 언더바는 브라우저 주소창에서 잘 보이지 않아 가독성을 해친다.
✅http://example.com/user-management
```

## 3. ✍️파일 확장자를 표시하지 않는다.
```
🚫http://example.com/photo1.jpg
🚫http://example.com/topic1.html
✅http://example.com/photos/1
✅http://example.com/topics/1
```

## 4. ✍️`CRUD`와 같은 행위를 포함하지 않는다.
```
🚫http://example.com/read/topics/1
🚫http://example.com/add/topics
🚫http://example.com/modify-topics
🚫http://example.com/delTopic
```

### 🧷`HTTP Metod`를 통해 행위를 표현해야 한다.

```html
✅http://example.com/topics/1

<a href="/topics/1">link</a>
<!-- 📨request message
GET /topics/1 HTTP/1.1
Accept: text/html,application/xhtml+xml
Accept-Encoding: gzip, deflate, br
Accept-Language: ko,en;q=0.9,en-US;q=0.8
Cache-Control: max-age=0
Host: 127.0.0.1:5500
User-Agent: Mozilla/5.0 ...
-->
```

```html
✅http://example.com/topics

<form action="/topics" method="post">
   <input type="text" name="title">
   <input type="submit"/>
</form>
<!-- 📨request message
POST /topics HTTP/1.1
Accept: text/html,application/xhtml+xml
Accept-Encoding: gzip, deflate, br
Accept-Language: ko,en;q=0.9,en-US;q=0.8
Cache-Control: max-age=0
Host: 127.0.0.1:5500
User-Agent: Mozilla/5.0 ...

title: restful 👈 body 값
-->
```

### 5. ✍️리소스를 필터링은 `Query string`를 이용한다.
- `Query string`는 `http://example.com/topics?name1=value&name2=value`형태로 주소와는 `?`이후에 속성의 이름과 값이 표시되며, 속성 간의 구분은 `&`로 이루어진다.
```
✅https://www.google.com/search?q=올해의+영화
// 구글에서 "올해의 영화"를 검색
✅https://www.youtube.com/results?search_query=영화&sp=EgIYAw%253D%253D
// 유튜브에서 "영화"를 검색, 필터 : 4~20분.
```

# 📖RESTful API 인증 방법

## HTTP 인증

- 기본 인증
   - 클라이언트 *요청 헤더*에 사용자 *이름*과 *암호*를 넣어 전송합니다.
   - 안전한 전송을 위해 `base64`로 인코딩합니다.
- 전달자 인증
   - *전달자 토큰*은 *서버*가 *로그인 요청*에 대한 *응답*으로 생성하는 *암호화된 문자열*입니다.
   - *클라이언트*는 리소스에 접근하기 위해 *요청 헤더*에* 토큰*을 넣어 전송합니다.

## API 키
- *서버*는 *고유*하게 생성된 *값*을 최초 *클라이언트에 할당*합니다.
- *클라이언트*는 리소스에 접근하려고 할 때마다 고유한 *API키*를 사용하여 *본인임을 검증*합니다.
- 이 방식은 클라이언트가 키를 전송해야 되서 네트워크 도난에 취약합니다.

## OAuth
- 모든 시스템에 대해 매우 안전한 로그인 엑서스를 보장하기 위해 *암호*와 *토큰*을 *결합*합니다.
- 서버는 먼저 암호를 요청한 다음, 권한 부여 프로세스를 완룧기 위해 추가 토큰을 요청합니다.
   - 선 암호, 후 토큰 요청
- 특정 범위와 수명으로 언제든지 토큰을 확인할 수 있습니다.