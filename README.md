 innovation03
###**수정,삭제 API의 request를 어떤 방식으로 사용하셨나요?**

- 수정API : @PathVariable로 id를 uri값으로 받고, @RequestBody로 데이터를 받아 수정한다.
- 삭제API : @PathVariable로 id를 받아, 해당 id값을 가진 데이터를 db에서 찾아 삭제한다.

###**어떤 상황에 어떤 방식의 request를 써야하나요?**

request의 유형은 4가지로

Create, Read, Update, Delete 즉 CRUD가 있다. 데이터를 생성하고 싶을 때는 Create request를 사용하고 저장돼있는 데이터를 읽거나 검색하는 때에는 Read, 기존 데이터를 수정할 때는 Update, 삭제를 할때는 Delete로 request를 사용한다. 

###**RESTful한 API를 설계했나요? 어떤 부분이 그런가요? 어떤 부분이 그렇지 않나요?**

REST API 설계 원칙

- 자원에 대한 행위는 HTTP Method로 표현한다.
- URI는 정보의 자원을 표현해야 한다.
    - 슬래시 구분자(/)는 계층 관계를 나타내는 데 사용한다.
    - URI 마지막 문자로 슬래시 구분자(/)를 사용하지 않는다.
    - 리소스 간 연관 관계가 있는 경우 {}를 통해 처리한다.
    - 가독성을 높이기 위해  *가 아닌 -을 사용한다.  ex) /hello*_world/ (X) /hello-world/ (o)
    - URI 경로에는 소문자가 적절하다.
    - 파일 확장자는 URI에 포험하지 않는다.
    - 기본적으로 명사를 사용하지만, 컨트롤 자원을 의미하는 경우 동사를 허용한다.

REST API 설계 원칙을 모르고 과제를 수행하였다. 제공된 강의의 틀에서 만들었기 때문에 크게 벗어난 부분은 없었다. 하지만 비밀번호 확인 조회 API부분에서 uri를  **/blogs/{id}** 가 아닌 **/blogs/password/{id}**로 만들어 리소스를 정확히 명시해주어야 할 것같다.

### **적절한 관심사 분리를 적용하였나요? (Controller, Repository, Service)**

공부를 하다보니 Controller가 가장 핵심적인 요소라고 생각됐다. Controller 

### **작성한 코드에서 빈(Bean)을 모두 찾아보세요!**
BlogRepository   BlogService   BlogRequestDto


### **API 명세서 작성 가이드라인을 검색하여 직접 작성한 명세서와 비교해보세요!**
API가 어떤 기능을 하는지 직관적으로 알 수 있게 uri 네이밍을 더 디테일하게 설정하는 것이 필요하다고 느껴졌다.
