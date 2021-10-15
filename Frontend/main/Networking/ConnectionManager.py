import requests


class ConnectionManager:
    __instance = None

    @classmethod
    def get_instance(cls):
        if ConnectionManager.__instance is None:
            ConnectionManager.__instance = ConnectionManager()
            return ConnectionManager.__instance

    def __init__(self):
        if ConnectionManager.__instance is not None:
            raise Exception("This is a singleton class ")
        else:
            print("Client attempting to connect")
            self.url = None
            ConnectionManager.__instance = self

    # asynchronous function to run HTTP GET request
    # input: URI of address to send GET request to (String)
    # return : asynchronous return from GET request to inputted URI
    def create_get_request(self, url):
        self.url = url
        user_request = requests.get(url)
        return user_request

    # Function for HTTP POST REQUEST
    # Input: url = location to send to, data = what to send
    def create_post_request(self, url, data):
        self.url = url
        user_post = requests.post(url, data)
        return user_post.text

    def test(self, url):
        self.url = url
        response_code = self.create_get_request( url)
        return response_code.status_code


#conn = ConnectionManager.get_instance()
#print(conn.test("http://localhost:7000/"))

