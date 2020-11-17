"""
Toni Fields
Student #001307628
"""


class HashTable(object):

    # Time Complexity: O(1)
    # Space Complexity: O(N)
    def __init__(self, capacity=10):
        # Creates hash table with a default list of 10
        self.capacity = capacity
        self.hash_map = [[] for _ in range(self.capacity)]

    # Hash Function
    # Time Complexity: O(1)
    # Space Complexity: O(1)
    def _hash_func(self, key):
        return key % self.capacity

    # Insertion Function
    # Time Complexity: O(1)
    # Space Complexity: O(1)
    def add(self, key, value):
        key = int(key)
        hash_key = self._hash_func(key)
        key_value = [key, value]

        if self.hash_map[hash_key] is None:
            self.hash_map[hash_key] = key_value
            return True
        else:
            self.hash_map[hash_key].append(key_value)
            return True

    # Look-Up Function
    # Time Complexity: O(N)
    # Space Complexity: O(1)
    def get(self, key):
        hash_key = self._hash_func(key)
        if self.hash_map[hash_key] is not None:
            if type(self.hash_map[hash_key]) is list:
                for x in range(len(self.hash_map[hash_key])):
                    if key in self.hash_map[hash_key][x]:
                        return self.hash_map[hash_key][x]
            else:
                return self.hash_map[hash_key][1]  # added last subscript of [1] might not be right TODO

        # If key isn't found, error message displays
        return 'Key wasn\'t found!'

    # Deletion Function
    # Time Complexity: O(N)
    # Space Complexity: O(1)
    def delete(self, key):
        hash_key = self._hash_func(key)
        if self.hash_map[hash_key] is None:
            return False
        for i in range(0, len(self.hash_map[hash_key])):
            if self.hash_map[hash_key][i][0] == key:
                self.hash_map[hash_key].pop(i)
                return True

    # Look-Up Function For Package_Info
    # Time Complexity: O(N)
    # Space Complexity: O(1)
    def get_package_info(self, key):
        hash_key = self._hash_func(key)
        if self.hash_map[hash_key] is not None:
            # If key exists, return value
            for hash_value in self.hash_map[hash_key]:
                if hash_value[0] == key:
                    return print(hash_value[1].info)
                    
        # If key isn't found, error message displays
        return KeyError

    # Look-Up Function For Package_Delivery_Status
    # Time Complexity: O(N)
    # Space Complexity: O(1)
    def get_package_status(self, key):
        hash_key = self._hash_func(key)
        if self.hash_map[hash_key] is not None:
            # If key exists, return value
            for hash_value in self.hash_map[hash_key]:
                if hash_value[0] == key:
                    return print(f'Package #{key}: {hash_value[1].status}')

        # If key isn't found, error message displays
        return KeyError

    # Time Complexity: O(N)
    # Space Complexity: O(1)
    def print(self):
        for values in self.hash_map:
            if values is not None:
                print('---Hash Table---')
                print(str(values))
