class Handler {
    setNext(handler) {
        this.nextHandler = handler;
    }

    handleRequest(request) {
        if (this.nextHandler) {
            return this.nextHandler.handleRequest(request);
        }
        return Promise.reject('No handler found');
    }
}

class GetHandler extends Handler {
    async handleRequest(request) {
        if (this.canHandle(request)) {
            const response = await fetch('http://localhost:8081/scheduleweb_war_exploded/api/menu/list');
            return response.json();
        }
        return super.handleRequest(request);
    }

    canHandle(request) {
        return request.method === 'GET';
    }
}

class PostHandler extends Handler {
    async handleRequest(request) {
        if (this.canHandle(request)) {
            const form = new FormData(request.form);
            const body = {};
            for (const [key, value] of form.entries()) {
                body[key] = value;
            }
            const response = await fetch('http://localhost:8081/scheduleweb_war_exploded/api/menu/add', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify(body),
            });
            return response.json();
        }
        return super.handleRequest(request);
    }

    canHandle(request) {
        return request.method === 'POST';
    }
}


class PutHandler extends Handler {
    async handleRequest(request) {
        if (this.canHandle(request)) {
            const response = await fetch(`http://localhost:8081/scheduleweb_war_exploded/api/menu/update/${request.id}`, {
                method: 'PUT',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify(request.body),
            });
            return response.json();
        }
        return super.handleRequest(request);
    }

    canHandle(request) {
        return request.method === 'PUT';
    }
}

class DeleteHandler extends Handler {
    async handleRequest(request) {
        if (this.canHandle(request)) {
            const response = await fetch(`http://localhost:8081/scheduleweb_war_exploded/api/menu/remove/${request.id}`, {
                method: 'DELETE',
            });
            return response.json();
        }
        return super.handleRequest(request);
    }

    canHandle(request) {
        return request.method === 'DELETE';
    }
}

const form = document.querySelector('#menuForm');
const getHandler = new GetHandler();
const postHandler = new PostHandler();
const putHandler = new PutHandler();
const deleteHandler = new DeleteHandler();

getHandler.setNext(postHandler);
postHandler.setNext(putHandler);
putHandler.setNext(deleteHandler);

form.addEventListener('submit', async (event) => {
    event.preventDefault();
    const formData = new FormData(event.target);
    const data = {};
    for (const [key, value] of formData.entries()) {
        data[key] = value;
    }
    let method = 'POST';
    let url = 'http://localhost:8081/scheduleweb_war_exploded/api/menu/add';
    let id = null;
    if (data.id) {
        id = data.id;
        delete data.id;
    }
    if (id) {
        method = 'PUT';
        url = `http://localhost:8081/scheduleweb_war_exploded/api/menu/update/${id}`;
    }
    if (data._method) {
        method = 'DELETE';
        url = `http://localhost:8081/scheduleweb_war_exploded/api/menu/remove/${data.id}`;
    }
    const request = {
        method: method,
        body: JSON.stringify(data),
        headers: {
            'Content-Type': 'application/json'
        }
    };
    if (method === 'GET') {
        const result = await getHandler.handleRequest(request);
        console.log(result);
    } else {
        await postHandler.handleRequest(request);
    }
    form.reset();
});


