# `RESTful`이란
- `REST`의 기본 원칙을 성실히 지킨 웹 서비스를 의미합니다.

# `REST API` 구성요소

## 📌자원(`Resource`)
- 

## 📌행위(`Verb`)

## 📌표현(`Representations`)

# ✍️`URI` 명명 규칙

## ✏️소문자로만 사용한다.
- 단어간 구분을 dash(`-`)를 통해 구분한다.
```
🚫http://example.com/userManagement    // 대문자 사용
🚫http://example.com/user_management   // 언더바(_) 사용
✅http://example.com/user-management
```
> 단, 단어간 구분이 불가피한 경우에만 사용해야 된다.

## ✏️마지막에 슬래시(`/`)를 포함하지 않는다.
```
✅http://example.com/users
✅http://example.com/posts
🚫http://example.com/users/
🚫http://example.com/posts/
```
> `/`는 계층을 구분하는 것임으로 마지막에는 사용하지 않는다.

## ✏️파일 확장자를 표시하지 않는다.
```
🚫http://example.com/photo1.jpg
🚫http://example.com/topic1.html
✅http://example.com/photos/1
✅http://example.com/topics/1
```

## ✏️행위(`Verb`)를 포함시키지 않는다.
```
🚫http://example.com/get-users
🚫http://example.com/create-post
✅http://example.com/users
// request : GET /users HTTP/1.1
✅http://example.com/posts
// request : POST /posts HTTP/1.1
```
> `HTTP Method`를 통해 표현해야 된다.

## ✏️자원의 필터링은 `Query string`을 이용한다.
```
✅https://www.google.com/search?q=올해의+영화
// 구글에서 "올해의 영화"를 검색
✅https://www.youtube.com/results?search_query=영화&sp=EgIYAw%253D%253D
// 유튜브에서 "영화"를 검색, 필터 : 4~20분
```

# 📢`HTTP` 상태코드

## 📨1XX
- 조건부 응답

## 📨2XX
- 성공

## 📨3XX
- 리다이렉션

## 📨4XX
- 클라이언트 오류

![404 상태 이상](img\404_state_message.jpg)

![404 상태 이상 받은 페이지](img\404_state_page.jpg)

## 📨5XX
- 서버 오류

![500 상태 이상](img\500_state_message.jpg)

![500 상태 이상 받은 페이지](img\500_state_page.jpg)