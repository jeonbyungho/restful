const origin = location.origin;
const pathname = location.pathname;

const doc_name    = document.getElementById('name');
const doc_address = document.getElementById('address');
const doc_email   = document.getElementById('email');
const doc_tel     = document.getElementById('tel');
const doc_bio     = document.getElementById('bio');

window.onload = () => {
   const index = pathname.lastIndexOf('/');
   const sub = pathname.substring(index + 1);

   const url = origin + '/people/info/' + sub;
   console.log('📢GET Request', url);

   fetch(url)
   .then(resp => {
      if (!resp.ok) {
         throw new Error('🤮 에러 응답을 받았습니다.');
      }
      return resp.json();
   })
   .then(json => {
      console.table(json);
      doc_name.innerHTML    = json['name'];
      doc_address.innerHTML = json['address'];
      doc_email.innerHTML   = json['email'];
      doc_tel.innerHTML     = json['tel'];
      doc_bio.innerHTML     = json['bio'];
   })
   .catch( (e) => {
      console.error(e.error);
   })
}

document.getElementById('back').onclick = (e)=> { window.history.back(); false;}