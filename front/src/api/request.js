const url = "http://localhost:8090/bankele/getTableAlemana"

export async function sendRequest(data){
    const requestOptions = {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(data)
    };
    const response = await fetch(url, requestOptions);
	const dataResponse = await response.json();
	return dataResponse;
}