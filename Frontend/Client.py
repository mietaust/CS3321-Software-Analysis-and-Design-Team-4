from ConnectionManager import ConnectionManager


class Client:

    def __init__(self):
        self.url = None

    def connect(self, url):
        self.url = url
        connection = ConnectionManager.get_instance()
        print(connection.create_get_request(url))

