/**
 * @e http://localhost:8080/
 * */
const origin = location.origin;

/**
 * @e url에서 pathinfo 추출
 * */
function sub_pathname() {
   const index = location.pathname.lastIndexOf('/');
   const info = location.pathname.substring(index + 1);
   return parseInt(info);
}

/**
 * @e url의 식별자
 * */
const pathinfo = sub_pathname();

/**
 * @e url의 식별자 존재 여부 확인
 * @NaN true
 * @number false
 * */
const isURLpathinfo = isNaN(pathinfo);

console.log('🍌element', location.href, pathinfo);

/**@Element 제목*/
const el_TitleLegend = document.getElementById('title');

/**@Element 삭제 버튼*/
const el_DelectButton = document.getElementById('del');

/**@Element 뒤로가기 버튼*/
const el_BackButton = document.getElementById('back');

/**@From 직원 추가및 직원 정보 수정*/
const from_proflie = document.getElementById('profile');

/**
 * @POST_Request
 * 직원 추가 요청
 */
function postProfile(e){
   e.preventDefault();
   // 입력란 값 확인.
   if(isfromInput()){
      console.log("🤔 아직 비어 있는 입력란이 있습니다.");
      return false;
   }
   console.log('📨POST Request', e.target);
   const from = e.target;

   // json 구성
   const data = {
      name     : from.name.value,
      address  : from.address.value,
      email    : from.email.value,
      tel      : from.tel.value,
   }

   // 요청 메시지 구성
   const url = origin + '/profile';
   const init = {
      method  : "POST",
      headers : {
         "Content-Type": "application/json",
      },
      body    : JSON.stringify(data)
   }

   console.log(url);
   console.log(init);
   // 요청 시작
   fetch(url, init).then(response => {
      if(response.ok){
         console.log('😀 POST 성공');
         alert('😀 ' + from.name.value + '님이 추가되었습니다.');
         history.back();
      }
   }).catch(error =>{
      console.error('😭 POST 실패', error);
      alert('😭 직원 추가에 실패하였습니다.');
   });
}

/**
 * @PUT_Request
 * 직원 프로필 정보 수정 요청
 */
function putProfile(e){
   e.preventDefault();
   // 입력란 값 확인.
   if(isfromInput()){
      console.log("🤔 아직 비어 있는 입력란이 있습니다.");
      return false;
   }
   console.log('📨PUT Request', e.target);
   const from = e.target;

   // json 구성
   const data = {
      id       : pathinfo,
      name     : from.name.value,
      address  : from.address.value,
      email    : from.email.value,
      tel      : from.tel.value,
   }

   // 요청 메시지 구성
   const url = origin + '/profile/' + pathinfo;
   const init = {
      method  : "PUT",
      headers : {
         "Content-Type": "application/json",
      },
      body    : JSON.stringify(data)
   }

   console.log(url);
   console.log(init);
   // 요청 시작
   fetch(url, init).then(response => {
      if(response.ok){
         console.log('😀 PUT 성공');
         alert('🥳 ' + from.name.value + '님의 정보가 수정되었습니다.');
      }
   }).catch(error =>{
      console.error('😭 PUT 실패', error);
      alert('😭 정보 수정에 실패하였습니다.');
   });
}

/**
 * @DELETE_Request
 * 직원 추가 요청
 */
function deleteProfile(e){
   console.log('📨DELETE Request', e.target);
   
   // 요청 메시지 구성
   const url = origin + '/profile/' + pathinfo;
   const init = {
      method  : "DELETE",
      headers : {
         "Content-Type": "application/json",
      },
   }
   
   console.log(url);
   console.log(init);
   // 요청 시작
   fetch(url, init).then(response => {
      if(response.ok){
         console.log('😀 DELETE 성공');
         alert('💀 ' + from_proflie.name.value + '님의 정보가 삭제되었습니다.');
         location.href = document.referrer;
         // history.back();
      }
   }).catch(error =>{
      console.error('😭 DELETE 실패', error);
      alert('😭 삭제 처리에 실패하였습니다.');
   });
}

/**
 * @GET_Request
 * 직원 정보 프로필 페이지에서 조회
 */
function getProfile(e){
   console.log('📨get Request', e.target);

   // 요청 메시지 구성
   const url = origin + '/profile/' + pathinfo +"?format=json";
   const init = {
      method  : "GET",
      headers : {
         "Content-Type": "application/json",
      },
   }

   console.log(url);
   console.log(init);
   // 요청 시작
   fetch(url, init).then(response => {
      if(response.ok){
         console.log('😀 GET 성공');
         return response.json();
      }
   }).then(json => {
      console.table(json);
      from_proflie.name.value    = json.name;
      from_proflie.address.value = json.address;
      from_proflie.email.value   = json.email;
      from_proflie.tel.value     = json.tel;

   }).catch(error =>{
      console.error('😭 GET 실패', error);
      alert('😭 조회가 안됩니다.');
      history.back();
   });
}

/**
 * @function 입력란 Value check
 * @true 비어 있는 입력란이 있을 경우..
 * @false 입력란을 모두 채웠을 경우..
 */
function isfromInput(){
   if(!from_proflie.name.value) {
      alert("✍️ 이름을 적어주세요.");
      return true;
   }
   if(!from_proflie.address.value) {
      alert("✍️ 주소을 적어주세요.");
      return true;
   }
   if(!from_proflie.email.value) {
      alert("✍️ 이메일을 적어주세요.");
      return true;
   }
   if(!from_proflie.tel.value) {
      alert("✍️ 전화 번호을 적어주세요.");
      return true;
   }
   return false;
}

/**
 * uri 식별 여부에 따라 화면 구성을 바꾼다.
 */
if(isURLpathinfo){
   console.log("🙂 직원 추가");
   el_TitleLegend.innerHTML = "직원 추가";
   el_DelectButton.style.display = 'none';

   from_proflie.onsubmit = postProfile;
} else {
   console.log("🤔 프로필 편집");
   el_TitleLegend.innerHTML = "프로필 수정";

   window.onpageshow = getProfile;
   from_proflie.onsubmit = putProfile;
   el_DelectButton.onclick = deleteProfile;
}