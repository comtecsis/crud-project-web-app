/**
 * La ruta siempre tiene que tener como fin /
 */
var baseUrl = window.location.href;

if(baseUrl[baseUrl.length-1] != "/")
{
	window.location.href = baseUrl+"/";
}

function contextUrl(path)
{
	var pos = path.indexOf(baseUrl);
	if(pos === -1)
	{
		return baseUrl + path;
	}
	return path;
}