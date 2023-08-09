// 사람 인적 사항 제출 버튼, 변수에 할당
let submit_button = document.getElementById('submit');

// Json 데이터 업로드
async function postPeople(){
   console.log('🏭POST Request : Uploading JSON data');

   const get_name = document.getElementById('name').value;
   const get_pwd = document.getElementById('pwd').value;
   const get_address = document.getElementById('address').value;
   const get_email = document.getElementById('email').value;
   const get_tel = document.getElementById('tel').value;

   console.log(get_name, get_pwd, get_address, get_email, get_tel);

   const data = {
      name : get_name,
      pwd : get_pwd,
      address : get_address,
      email : get_email,
      tel : get_tel,
   };
   
   // 요청 메시지 구성
   try{
      const url = 'http://localhost:8080/people';
      const init = {
         method : "POST",
         headers : {
            "Content-Type": "application/json",
         },
         body: JSON.stringify(data)
      };
      console.log('🌐 URL', url);
      console.log('🫙 init', init);
      
      const resp = await fetch(url, init);
      if(resp.ok){
         console.error("😀: POST 성공");
      }
   } catch(error) {
      console.error("🤮:", error);
   }
}

// const data = {
//    name : "lee",
//    age : 20
// };

document.getElementById('submit').addEventListener('click', () => postPeople());