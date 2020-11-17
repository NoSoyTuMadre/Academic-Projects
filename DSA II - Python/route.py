"""
Toni Fields
Student #001307628
"""

import datetime
import hash_table

numbers = 0


class Package:
    all_packages = []
    pkg_table = hash_table.HashTable()
    time_delivered = None

    # Time Complexity: O(1)
    # Space Complexity: O(N)
    def __init__(self, pkg_id, address, city, zip_code, deadline, kilos, notes):
        self.pkg_id = int(pkg_id)
        self.address = address
        self.city = city
        self.zip_code = zip_code
        self.deadline = deadline
        self.kilos = kilos
        self.notes = notes
        self.status = 'At Warehouse'
        self.time_delivered = None
        self.all_packages.append(self)
        self.pkg_table.add(self.pkg_id, self)
        self.info = str(f'***********************************\nID: {self.pkg_id}\nAddress: {self.address}\n'
                        f'         {self.city} {self.zip_code}\nDeadline: {self.deadline}\nMass: {self.kilos}\n'
                        f'Notes: {self.notes}\nStatus: {self.status}\n***********************************\nID: \n')
        print(f'Package #{self.pkg_id} created!')

    # Time Complexity: O(1)
    # Space Complexity: O(1)
    def __str__(self):
        print(self.pkg_id)

    # Time Complexity: O(1)
    # Space Complexity: O(1)
    def is_loaded(self):
        if self.status == 'En route':
            return True
        return False

    # Time Complexity: O(1)
    # Space Complexity: O(1)
    def is_delivered(self):
        if 'Delivered' in self.status:
            return True
        return False

    # Time Complexity: O(1)
    # Space Complexity: O(1)
    def is_delayed(self):
        if self.status == 'Delayed':
            return True
        return False

    # Time Complexity: O(1)
    # Space Complexity: O(1)
    def delivery_status(self):
        print(f'Package #{self.pkg_id} Status: {self.status}')

    # Time Complexity: O(1)
    # Space Complexity: O(1)
    def package_info(self):
        print(f'ID: {self.pkg_id}')
        print(f'Address: {self.address}')
        print(f'         {self.city} {self.zip_code}')
        print(f'Deadline: {self.deadline}')
        print(f'Mass: {self.kilos}')
        print(f'Notes: {self.notes}')
        print(f'Status: {self.status}')


class Route:
    total_miles = 0

    # Time Complexity: O(1)
    # Space Complexity: O(1)
    def __init__(self):
        global numbers
        numbers += 1
        print(f'Route #{numbers} created!')
        self.route_id = numbers
        self.truck = None
        self.driver = None
        self.route = []
        self.packages = []

    # Time Complexity: O(1)
    # Space Complexity: O(1)
    def add_truck(self, truck_num):
        if truck_num not in Truck.all_trucks:
            Truck(truck_num)
            self.truck = truck_num
            self.packages = truck_num.loaded_packages

    # Time Complexity: O(1)
    # Space Complexity: O(1)
    def add_path(self, graph):
        self.route = graph


class Truck:
    all_trucks = []

    # Time Complexity: O(1)
    # Space Complexity: O(1)
    def __init__(self, truck_num):
        self.loaded_packages = []
        self.truck_num = truck_num
        self.driver = None
        self.all_trucks.append(self)
        print(f'Truck #{self.truck_num} created!')

    # Time Complexity: O(1)
    # Space Complexity: O(1)
    def add_driver(self, driver):
        if driver in Driver.all_drivers:
            self.driver = driver
            print(f'Driver {self.driver.name} is assigned to Truck #{self.truck_num}!')

    # Time Complexity: O(N)
    # Space Complexity: O(1)
    def load_truck(self, package_list):
        for each in package_list:
            self.loaded_packages.append(each)
            index = Package.all_packages.index(each.pkg_id)
            Package.all_packages[index].status = 'En route'
            each.status = 'En route'
            if self.is_overloaded():
                return

    # Time Complexity: O(N)
    # Space Complexity: O(1)
    def unload_truck(self, package_list):
        for each in package_list:
            self.loaded_packages.remove(each)
            each.status = 'At Warehouse'

    # Time Complexity: O(1)
    # Space Complexity: O(1)
    def is_overloaded(self):
        num_packages = len(self.loaded_packages)
        # Each truck can carry up to 16 packages
        if num_packages > 16:
            print('Package maximum capacity is 16! You must remove packages!')
            return True
        return False


class Driver:
    _speed = 18
    _time = 60
    _miles_per_second = 18 / 3600
    truck_num = 0
    truck_num += 1
    all_drivers = []

    # Time Complexity: O(1)
    # Space Complexity: O(1)
    def __init__(self, name):
        self.name = name
        self.truck_no = self.truck_num
        self.all_drivers.append(self)
        self.current_date = datetime.datetime.now()
        self.start_time = datetime.datetime.combine(self.current_date.today(), datetime.time(8, 0))
        self.last_delta_time = datetime.timedelta(seconds=0)
        self.finish_time = datetime.datetime.combine(datetime.date(self.current_date.year, self.current_date.month, self.current_date.day),
                                                     datetime.time(self.start_time.hour, self.start_time.minute)) + self.last_delta_time
        print(f'Driver {self.name} created!')

    # Total miles driven
    # Time Complexity: O(1)
    # Space Complexity: O(1)
    def drive(self, miles):
        Route.total_miles += miles
        new_seconds = miles / self._miles_per_second
        self.last_delta_time = self.last_delta_time + datetime.timedelta(seconds=new_seconds)
        self.finish_time = datetime.datetime.combine(datetime.date(self.current_date.year, self.current_date.month, self.current_date.day),
                                                     datetime.time(self.start_time.hour, self.start_time.minute)) + self.last_delta_time
