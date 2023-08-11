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

console.log('🍌collection', location.href, pathinfo);

/**@Element 리스트*/
const el_list = document.getElementById('list');

/**@Element 페이지 목록*/
const el_page = document.getElementById('page');

/**
 * @function 목록에 프로필 표시
 * @param profile id, name, address, email, tel
*/
function itemCreate(profile){
   
   let name = document.createElement('legend');
   let address = document.createElement('p');
   let email = document.createElement('p');
   let tel = document.createElement('p');
   let hyperlink = document.createElement('a');

   name.innerHTML = profile.name;
   address.innerHTML = "🏠 " + profile.address;
   email.innerHTML = "📧 " + profile.email;
   tel.innerHTML = "📞 " + profile.tel;
   hyperlink.innerHTML = "🔍 " + '조회';
   hyperlink.setAttribute('href', '/profile/' + profile.id);

   let fieldset = document.createElement('fieldset');
   fieldset.appendChild(name);
   fieldset.appendChild(address);
   fieldset.appendChild(email);
   fieldset.appendChild(tel);
   fieldset.appendChild(hyperlink);

   return fieldset;
}

/**
 * @GET_Request
 * 직원 프로필 목록 가져오기
 */
function getEmployeeList(){
   console.log('📨get Request');

   // 요청 메시지 구성
   let url;
   if(isURLpathinfo){
      url = origin + '/employees'+ "?format=json";
   } else {
      url = origin + '/employees/' + pathinfo + "?format=json";
   }
   
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
      console.log(json);
      const list = json.list;
      const page = parseInt(json.page);
      console.log('페이지 목록',page);
      console.table(list);
      // 프로필 생성
      for(let i = 0; i < list.length; i++){
         const profile = list[i];
         let fieldset = itemCreate(profile);
         console.log('📜',profile, fieldset);
         el_list.appendChild(fieldset);
      }
      // 페이지 목록 생성
      for(let i = 1; i <= page; i++){
         let pagelink = document.createElement('a');
         pagelink.setAttribute('href', '/employees/' + i);
         pagelink.innerHTML = i;
         el_page.appendChild(pagelink);
      }
   }).catch(error =>{
      console.error('😭 GET 실패', error);
      alert('😭 조회가 안됩니다.');
      history.back();
   });
}

/** 
 * 이 페이지가 로드되면 목록을 화면에 띄웁니다.
*/

window.onpageshow = getEmployeeList;

