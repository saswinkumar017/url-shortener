async function shortenUrl(){
    const url=document.getElementById("url").value;

    const response = await fetch(
        "https://url-shortener-production-00ad.up.railway.app/add",
        {
            method:"POST",
            headers:{
                "Content-Type":"application/json"
            },
            body: JSON.stringify(
                {url:url}
            )
        }
    );
    const data = await response.json();
    console.log(data);
    const shorturl=`https://url-shortener-n.netlify.app/${data.shortCode}`;
    
    document.getElementById("short-url").href=shorturl;
    document.getElementById("short-url").innerText=shorturl;
    document.getElementById("result-card").classList.remove("hidden");
    document.getElementById("copy-btn").onclick=async()=>{
        navigator.clipboard.writeText(shorturl);
    };

}
async function handleRedirect() {

const path =
    window.location.pathname;

const shortCode =
    path.split("/").pop();
    console.log(shortCode);

if ( shortCode &&shortCode!=="client") {

    const response =
        await fetch(
            `https://url-shortener-production-00ad.up.railway.app/${shortCode}`
        );
        console.log(response);
    const originalUrl=await response.text();
    console.log(originalUrl);

    // window.location.href=`originalUrl;
}

}

handleRedirect();