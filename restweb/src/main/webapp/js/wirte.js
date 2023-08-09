// Json 데이터 업로드
const origin = location.origin;

async function postPeople(){
   console.log('🏭POST Request : Uploading JSON data');

   const get_name    = document.getElementById('name').value;
   const get_pwd     = document.getElementById('pwd').value;
   const get_address = document.getElementById('address').value;
   const get_email   = document.getElementById('email').value;
   const get_tel     = document.getElementById('tel').value;
   const get_bio     = document.getElementById('bio').value;

   const data = {
      name    : get_name,
      pwd     : get_pwd,
      address : get_address,
      email   : get_email,
      tel     : get_tel,
      bio     : get_bio,
   };

   console.table(data);
   
   // 요청 메시지 구성
   try{
      const url = origin + '/people';
      const init = {
         method  : "POST",
         headers : {
            "Content-Type": "application/json",
         },
         body    : JSON.stringify(data)
      };
      console.log('🌐 URL', url);
      console.log('🫙 init', init);
      
      const resp = await fetch(url, init);
      if(resp.ok){
         console.log("😀: POST 성공");
         alert('😀 '+ get_name +"님이 추가되었습니다.");
         history.back();
      }
   } catch(error) {
      console.error("🤮:", error);
   }
}

// const data = {
//    name : "lee",
//    age : 20
// };

document.getElementById('submit').onclick =  (e) => postPeople();
document.getElementById('back').onclick =    (e) => { window.history.back(); false;}