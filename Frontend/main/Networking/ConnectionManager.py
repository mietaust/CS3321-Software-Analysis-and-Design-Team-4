import requests


class ConnectionManager:
    __instance = None

    @classmethod
    def get_instance(cls, url):
        if ConnectionManager.__instance is None:
            ConnectionManager.__instance = ConnectionManager(url)
            return ConnectionManager.__instance

    def __init__(self, url):
        if ConnectionManager.__instance is not None:
            raise Exception("This is a singleton class ")
        else:
            print("Client attempting to connect")
            self.url = url
            ConnectionManager.__instance = self

    # asynchronous function to run HTTP GET request
    # input: URI of address to send GET request to (String)
    # return : asynchronous return from GET request to inputted URI
    def create_get_request(self):
        user_request = requests.get(self.url)
        return user_request

    # Function for HTTP POST REQUEST
    # Input: url = location to send to, data = what to send
    def create_post_request(self, data):
        user_post = requests.post(self.url, data)
        return user_post

    def test(self, url):
        self.url = url
        response_code = self.create_get_request()
        return response_code.status_code

