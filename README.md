# **`RESTful`** (`Representational State Transfer`)

## 📕단어 사전적 의미

`REpresentational`
1. 구상화, **재현적**

`State`
1. **상태**

`Transfer`
1. (동사) 옮기다, 이송하다, **이동하다**.
2. (명사) 이동, 이적

`-ful`
1. ~이 가득한, ~의 성격을 지닌, **~의 경향이 있는**
1. ~을 가득 채울 정도의 양

> 네이버 사전

# ❓`REST`란?

- 분산 하이퍼 미디어 시스템(`Distributed Hypermedia Systems`)을 위한 소프트웨어 아키텍쳐입니다.
- REST 아키텍처 스타일을 따르는 API를 `REST API`라고 하며, REST 아키텍처를 기반으로 하는 웹 서비스를 `RESTful` 웹 서비스라고 합니다.
- 이러한 웹서비스는 `HTTP 메서드`를 사용하여 `REST` 아키텍처의 개념을 구현합니다.

# 🦺`REST`의 기본 원칙

## 1. 균일한 인터페이스 (`Uniform Interface`)
- 자원에 대한 요청이 통일되어 HTTP 표준 프로토콜에 따른다면, 언어나 기술에 종속되지 않습니다.

## 2. 클라이언트-서버 (`Client-Server`)
- 서버와 클라이언트로 구분되어 각 역할이 명확하고 서로 간의 의존성이 줄어듭니다.

## 3. 무상태 (`Statelessness`)
- 서버가 클라이언의 세션의 상태(`state about the client session`)를 저장(`not store`)하지 않음을 의미합니다.
- `Context`를 서버에 전달하는 것은 클라이언트 책임이며, 서버는 context

## 4. 캐시 처리 가능 (`Cacheable`)
- HTTP가 가진 캐싱 기능을 적용할 수 있습니다.
- 대량의 요청을 효율적으로 처리할 수 있습니다.

### 5. 계층화 시스템 (`Layered System`)
- 보안, 로드밸런싱, 암호화 등 계층을 추가하여 구조 변경이 가능합니다.
- API Gateway, Proxy 사용이 가능합니다.

## 6. 자체 표현 구조
- 자체 표현 구조로 되어 있어 메서드 자체로만으로 무슨 행위를 하는 지 알 수 있습니다.

# ⚙️`REST`의 구성

- 자원(`Resource`) : `URI`(`Uniform Resource Identifier`)
    - 각 리소스들은 URI로 식별됩니다.
    > URL: 자원이 실제로 존재하는 위치를 가리킵니다.  
    > URI: 자원의 위치뿐만 아니라 자원에 대한 고유 식별자로서 URL을 의미를 포함됩니다.

- 행위(`Verb`) : `HTTP Method`
    - `GET` : 읽기
    - `POST` : 생성
    - `PUT`, `PATCH` : 전체 수정, 부분 수정
    - `DELETE` : 삭제

- 표현(`Representation`) :
    - 클라이언트와 서버가 데이터를 주고 받을 때, 데이터의 형식. `JSON`, `XML`, `TEXT` 등이 있다. (Payload)
    > REST API를 이용해서 데이터를 주고 받을 시, 어떤 형식으로 

# ✍️`URI` 명명 규칙

## 리소스는 명사로 표현

```
localhost/user
localhost/customer
localhost/topic
```

## 컬렉션은 복수로 표현

```
localhost/users
localhost/accounts
localhost/topics
```

## 단어간 구분은 dash(`-`)로..

```
✅localhost/user-management
🚫localhost/userManagement
🚫localhost/user_management
```

## 파일 확장자은 포함되면 안된다.
```
🚫localhost/index.html
```

---

# 🌐참고 사이트

## 문서
- https://aws.amazon.com/ko/what-is/restful-api/
- https://restfulapi.net
- https://www.tutorialspoint.com/restful/restful_quick_guide.htm

## 블로그

### 네이버
- https://blog.naver.com/sportqrv443/223165864536
- https://blog.naver.com/nodame3806/222820890109
- https://blog.naver.com/ssooongg/223092677280

### 티스토리
- https://thalals.tistory.com/284
- https://kaypen.tistory.com/672
- https://sanghaklee.tistory.com/57
- https://dev-coco.tistory.com/97
- https://bcho.tistory.com/953
- https://hahahoho5915.tistory.com/54
- https://kks2140501.tistory.com/48
- https://diary-developer.tistory.com/10

### 그 외
- https://appmaster.io/ko/blog/nameoji-api-yeje
- https://brunch.co.kr/@ogaa2143/30

## 동영상
- https://youtu.be/xWA1eTPSzDE
- https://youtu.be/PmY3dWcCxXI