"""
Toni Fields
Student #001307628
"""

from datetime import datetime, time, timedelta
from graph import Graph
from route import Route
from route import Truck
from route import Driver
from hash_table import HashTable
from route import Package

total_time_start = datetime.now()


def gui_decorator(function):
    def wrap_function():
        print('***************************************************************************')
        print('               Welcome to WGUPS Package Tracking System!')
        print('***************************************************************************')
        function()
    return wrap_function


# Create hash table with data from WGUPS Package File
#
num_locations = 27  # number of locations
package_object = HashTable(num_locations)
locations_map = HashTable(num_locations)
adj_list = HashTable(num_locations)
total_miles_group1 = 0
total_miles_group2 = 0
total_miles_group3 = 0
graph1 = Graph()
graph2 = Graph()
graph3 = Graph()
route1 = Route()
route2 = Route()
route3 = Route()

# Reading in data from package file
# Time Complexity: O(N)
# Space Complexity: O(N)
with open('WGUPS Package File.csv', mode='r', encoding='utf-8-sig') as packages:
    string = packages.readlines()
    for _ in range(40):
        aaa, bbb, ccc, ddd, eee, fff, ggg, hhh = string[_].split(sep=',', maxsplit=7)
        ccc = ccc + ', ' + ddd
        aaa = int(float(aaa))
        package_object.add(aaa, Package(aaa, bbb, ccc, eee, fff, ggg, hhh))

# Create an array for inclusion in adjacency list from WGUPS Distance Table
#
with open('WGUPS Distance Table.csv', mode='r', encoding='utf-8-sig') as distances:
    string = distances.readlines()
    distances_list = []
    temp_list = []

    # Time Complexity: O(N^2)
    # Space Complexity: O(N)
    def get_missing_values():
        start_index = 0
        end_index = 1

        for x_one in range(0, num_locations):
            if '' in distances_list[x_one]:
                for new_index in range(start_index, end_index):
                    distances_list[x_one][new_index] = temp_list[x_one][new_index]
                end_index += 1


    # Combine 2 lists to fully populate distance_table given & add values to adjacency hash table
    # Time Complexity: O(N)
    # Space Complexity: O(N)
    for _ in range(0, num_locations):
        a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z, aa = string[_].split(sep=',')
        if aa == '\n':
            aa = ''
        temp_list.append([a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z, aa])

    # Time Complexity: O(N^2)
    # Space Complexity: O(N)
    for num in range(0, num_locations):
        distances_list.append([item[num] for item in temp_list])
        adj_list.add(num, distances_list[num])

get_missing_values()
Graph.main_adj_list = adj_list

# Create an array of locations to map to distances_list from Locations file
#
with open('Locations.csv', mode='r', encoding='utf-8-sig') as locations:
    string = locations.readlines()
    l_rows, l_cols = (num_locations, 2)

    # Time Complexity: O(N^2)
    # Space Complexity: O(1)
    locations_array = [[0 for i in range(l_cols)] for j in range(l_rows)]

    # Time Complexity: O(N)
    # Space Complexity: O(N)
    for _ in range(num_locations):
        number, address = string[_].split(sep=',', maxsplit=1)
        locations_array[_][0], locations_array[_][1] = int(number), address

# Create locations map that maps package IDs to location IDs
# Time Complexity: O(N^2)
# Space Complexity: O(N)
for each_p in Package.all_packages:
    for each_r in range(num_locations):
        if each_p.address[0:5] in locations_array[each_r][1]:
            pppp = int(each_p.pkg_id)
            locations_map.add(pppp, locations_array[each_r][0])

# Creates 3 trucks as per rubric requirements
#
truck1 = Truck(1)
truck2 = Truck(2)
truck3 = Truck(3)

# Creates 2 drivers as per rubric requirements
#
driver1 = Driver('Chuck')
# Set driver1's start time of 8:00 a.m.
driver1.current_time = datetime(datetime.now().year, datetime.now().month, datetime.now().day, 8, 0, 0, 0).time()

driver2 = Driver('Bobby')
# Set driver2's start time of 8:00 a.m.
driver2.current_time = datetime(datetime.now().year, datetime.now().month, datetime.now().day, 8, 0, 0, 0).time()

# Add drivers to trucks truck1 and truck2 initially
#
truck1.add_driver(driver1)
truck2.add_driver(driver2)

# Add packages to trucks (hand-sorted)
#
group1, group2, group3 = [], [], []
group1.append(Package.all_packages[0])
group1.append(Package.all_packages[6])
group1.append(Package.all_packages[10])
group1.append(Package.all_packages[11])
group1.append(Package.all_packages[12])
group1.append(Package.all_packages[13])
group1.append(Package.all_packages[14])
group1.append(Package.all_packages[15])
group1.append(Package.all_packages[18])
group1.append(Package.all_packages[19])
group1.append(Package.all_packages[20])
group1.append(Package.all_packages[21])
group1.append(Package.all_packages[22])
group1.append(Package.all_packages[28])
group1.append(Package.all_packages[33])
group1.append(Package.all_packages[38])

# Add vertices to graph1
# Time Complexity: O(N)
# Space Complexity: O(N)
for each_one in group1:
    graph1.add_vertex(locations_map.get(each_one.pkg_id)[1] - 1)

# Add edges to graph1
# Time Complexity: O(N^2)
# Space Complexity: O(N)
new_list = []
for y in range(num_locations):
    for x in range(num_locations):
        new_list = Graph.main_adj_list.get(y)[1]
        if new_list[x] != 0:
            graph1.add_edge(y, x, new_list[x])

# Leaves at 9:05 a.m.
group2.append(Package.all_packages[2])
group2.append(Package.all_packages[7])
group2.append(Package.all_packages[17])
group2.append(Package.all_packages[29])
group2.append(Package.all_packages[30])
group2.append(Package.all_packages[35])
group2.append(Package.all_packages[36])
group2.append(Package.all_packages[37])
group2.append(Package.all_packages[39])

# Add vertices to graph2
# Time Complexity: O(N)
# Space Complexity: O(N)
for each_one in group2:
    graph2.add_vertex(locations_map.get(each_one.pkg_id)[1] - 1)

# Add edges to graph2
# Time Complexity: O(N^2)
# Space Complexity: O(N)
new_list = []
for y in range(num_locations):
    for x in range(num_locations):
        new_list = Graph.main_adj_list.get(y)[1]
        if new_list[x] != 0:
            graph2.add_edge(y, x, new_list[x])

# Load trucks
# Time Complexity: O(N)
# Space Complexity: O(1)
map(truck1.load_truck, group1)
map(truck2.load_truck, group2)


def start_third_truck():
    global total_miles_group3
    global next_stop

    # Wait to load third truck until address has been corrected on Package #9
    #
    if truck3.driver.finish_time.time() > datetime(datetime.now().year, datetime.now().month, datetime.now().day, 9, 5, 0).time():
        Package.all_packages[8].address = '410 S State St'

        # Leaves as soon as one truck comes back
        group3.append(Package.all_packages[1])
        group3.append(Package.all_packages[3])
        group3.append(Package.all_packages[4])
        group3.append(Package.all_packages[5])
        group3.append(Package.all_packages[8])
        group3.append(Package.all_packages[9])
        group3.append(Package.all_packages[16])
        group3.append(Package.all_packages[23])
        group3.append(Package.all_packages[24])
        group3.append(Package.all_packages[25])
        group3.append(Package.all_packages[26])
        group3.append(Package.all_packages[27])
        group3.append(Package.all_packages[31])
        group3.append(Package.all_packages[32])
        group3.append(Package.all_packages[34])

        # Create a graph for group3 packages
        # graph3 = Graph()
        # graph3.add_vertex(0)

        # Add vertices to graph3
        # Time Complexity: O(N)
        # Space Complexity: O(N)
        for each_one3 in group3:
            graph3.add_vertex(locations_map.get(int(each_one3.pkg_id))[1] - 1)

        # Add edges to graph3
        # Time Complexity: O(N^2)
        # Space Complexity: O(N)
        for ranger in range(num_locations):
            for rangers in range(num_locations):
                new_list3 = Graph.main_adj_list.get(y)[1]
                if new_list3[x] != 0:
                    graph3.add_edge(y, x, new_list3[x])

        # Time Complexity: O(N)
        # Space Complexity: O(1)
        map(truck3.load_truck, group3)

        # Adds truck to route3
        #
        route3.add_truck(truck3)

        # Adds truck driver to truck
        #
        truck_driver = truck3.driver

        # Manual addition of packages that must be delivered first to meet deadline:
        #
        graph3.path_list.append([0, 0])
        total_miles_group3 += 2.4
        total_miles_group3 += 7.2
        truck_driver.drive(2.4)
        deliver_package(truck_driver, Package.all_packages[24])
        delivered_packages.append(Package.all_packages[24].pkg_id)
        deliver_package(truck_driver, Package.all_packages[25])
        delivered_packages.append(Package.all_packages[25].pkg_id)
        truck_driver.drive(7.2)
        deliver_package(truck_driver, Package.all_packages[5])
        delivered_packages.append(Package.all_packages[5].pkg_id)
        graph3.path_list.append([24, 2.4])
        graph3.path_list.append([13, 7.2])
        graph3.dest_list.remove(24)
        graph3.dest_list.remove(24)
        graph3.dest_list.remove(13)
        graph3.is_first = False

        # Implementation of shortest-path nearest-neighbor algorithm: Graph 3
        #
        next_stop = [13, 7.2]

        # Time Complexity: O(N^2)
        # Space Complexity: O(1)
        for ranging in range(len(set(graph3.dest_list))):
            next_stop = graph3.find_shortest_path(next_stop[0])
            total_miles_group3 += next_stop[1]
            truck_driver.drive(next_stop[1])
            for packaging in group3:
                if (locations_map.get(int(packaging.pkg_id))[1] - 1) == next_stop[0]:
                    deliver_package(truck_driver, packaging)
                    delivered_packages.append(packaging.pkg_id)
        next_stop = graph3.go_home(next_stop[0])
        total_miles_group3 += next_stop[1]
        truck_driver.drive(next_stop[1])


# Add trucks truck1 and truck2 to routes route1 and route2 initially
#
route1.add_truck(truck1)
route2.add_truck(truck2)

delivered_packages = []


# Package delivery function
# Time Complexity: O(N^2)
# Space Complexity: O(1)
def deliver_package(driver, package_delivered):
    global delivered_packages
    package_delivered.time_delivered = driver.finish_time
    package_delivered.status = str(f'Delivered at {package_delivered.time_delivered.strftime("%H:%M")}')
    truck = driver.truck_no
    for trucks in Truck.all_trucks:
        # print(f'Trucks: {trucks.truck_num}')
        if trucks.truck_num == truck:
            # print(f'Truck No: {truck}')
            for tp in trucks.loaded_packages:
                # print(f'P.pkg_id: {tp.pkg_id}')
                # print(f'Package_delivered id: {package_delivered.pkg_id}')
                if tp.pkg_id == package_delivered.pkg_id:
                    # print(f'tp.pkg_id: {tp.pkg_id}')
                    new_package = Package.pkg_table.get(tp.pkg_id)
                    new_package[1].status = str(f'Delivered at {tp.time_delivered.strftime("%H:%M")}')
                    tp.pkg_id.status = str(f'Delivered at {tp.time_delivered.strftime("%H:%M")}')
                    trucks.loaded_packages.remove(tp)



# Implementation of shortest-path nearest-neighbor algorithm: Graph 1
# Time Complexity: O(N^2)
# Space Complexity: O(N)
next_stop = [0, 0]
for each in range(len(set(graph1.dest_list))):
    next_stop = graph1.find_shortest_path(next_stop[0])
    total_miles_group1 += next_stop[1]
    driver1.drive(next_stop[1])
    for package in group1:
        if (locations_map.get(int(package.pkg_id))[1] - 1) == next_stop[0]:
            deliver_package(driver1, package)
            delivered_packages.append(package.pkg_id)

next_stop = graph1.go_home(next_stop[0])
total_miles_group1 += next_stop[1]
driver1.drive(next_stop[1])

# Implementation of shortest-path nearest-neighbor algorithm: Graph 2
# Time Complexity: O(N^2)
# Space Complexity: O(N)
next_stop = [0, 0]
for each in range(len(set(graph2.dest_list))):
    next_stop = graph2.find_shortest_path(next_stop[0])
    total_miles_group2 += next_stop[1]
    driver2.drive(next_stop[1])
    for package in group2:
        if (locations_map.get(int(package.pkg_id))[1] - 1) == next_stop[0]:
            deliver_package(driver2, package)
            delivered_packages.append(package.pkg_id)

next_stop = graph2.go_home(next_stop[0])
total_miles_group2 += next_stop[1]
driver2.drive(next_stop[1])

if driver1.finish_time < driver2.finish_time:
    truck3.add_driver(driver1)
    start_third_truck()
if driver1.finish_time > driver2.finish_time:
    truck3.add_driver(driver2)
    start_third_truck()


# Functions used for command line user interface
# Time Complexity: O(N)
# Space Complexity: O(1)
def find_answer(answer):
    if answer == 'ALL':
        for ran in range(1, len(Package.all_packages) + 1):
            print('***************************************************************************')
            pack = Package.pkg_table.get(ran)[1]
            if 'Delivered' not in pack.status:
                pack.package_info()
            elif 'Delivered' in pack.status:
                new_str = pack.status.strip('Delivered at ')
                hr, mn = new_str.split(sep=':', maxsplit=1)
                new_time = datetime.combine(datetime.today(), time(int(hr), int(mn)))
                if new_time > datetime.now() > datetime.combine(datetime.today(), time(8, 0, 0)):
                    if pack.pkg_id == 9:
                        pack.status = 'Delayed'
                        pack.package_info()
                        pack.status = f'Delivered at {new_str}'
                    elif 'Delayed' in pack.notes and datetime.now() < datetime.combine(datetime.today(), time(9, 5, 0)):
                        pack.status = 'Delayed'
                        pack.package_info()
                        pack.status = f'Delivered at {new_str}'
                    else:
                        pack.status = 'En route'
                        pack.package_info()
                        pack.status = f'Delivered at {new_str}'
                elif datetime.now().time() > new_time.time():
                    pack.package_info()
                elif datetime.now() < datetime.combine(datetime.today(), time(8, 0, 0)):
                    pack.status = 'At Warehouse'
                    pack.package_info()
                    pack.status = f'Delivered at {new_str}'
            print('***************************************************************************')

        return question()
    if answer == 'SEARCH':
        search_answer = input('What is the package ID number that you wish to search for? ')
        try:
            value = int(search_answer)
            pack = Package.pkg_table.get(value)[1]
            if 'Delivered' not in pack.status:
                pack.package_info()
            elif 'Delivered' in pack.status:
                new_str = pack.status.strip('Delivered at ')
                hr, mn = new_str.split(sep=':', maxsplit=1)
                new_time = datetime.combine(datetime.today(), time(int(hr), int(mn)))
                if new_time > datetime.now() > datetime.combine(datetime.today(), time(8, 0, 0)):
                    if pack.pkg_id == 9 and datetime.now() < datetime.combine(datetime.today(), time(10, 20, 0)):
                        print(f'Package 9 B4 Status: {pack.status}')
                        pack.status = 'Delayed'
                        pack.package_info()
                        pack.status = f'Delivered at {new_str}'
                    elif 'Delayed' in pack.notes and datetime.now() < datetime.combine(datetime.today(), time(9, 5, 0)):
                        print(f'Package Delayed B4 Status: {pack.status}')
                        pack.status = 'Delayed'
                        pack.package_info()
                        pack.status = f'Delivered at {new_str}'
                    else:
                        pack.status = 'En route'
                        pack.package_info()
                        pack.status = f'Delivered at {new_str}'
                elif datetime.now() > new_time:
                    pack.package_info()
                elif datetime.now() < datetime.combine(datetime.today(), time(8, 0, 0)):
                    pack.status = 'At Warehouse'
                    pack.package_info()
                    pack.status = f'Delivered at {new_str}'
            return question()
        except ValueError:
            print('Input must be an integer!')
            find_answer('SEARCH')
    if answer == 'ALL_STATUS':
        for ran in range(1, len(Package.all_packages) + 1):
            pack = Package.pkg_table.get(ran)[1]
            if 'Delivered' not in pack.status:
                pack.package_info()
            elif 'Delivered' in pack.status:
                new_str = pack.status.strip('Delivered at ')
                hr, mn = new_str.split(sep=':', maxsplit=1)
                new_time = datetime.combine(datetime.today(), time(int(hr), int(mn)))
                if new_time > datetime.now() > datetime.combine(datetime.today(), time(8, 0, 0)):
                    if pack.pkg_id == 9:
                        pack.status = 'Delayed'
                        pack.delivery_status()
                        pack.status = f'Delivered at {new_str}'
                    elif 'Delayed' in pack.notes and datetime.now() < datetime.combine(datetime.today(), time(9, 5, 0)):
                        pack.status = 'Delayed'
                        pack.delivery_status()
                        pack.status = f'Delivered at {new_str}'
                    else:
                        pack.status = 'En route'
                        pack.delivery_status()
                        pack.status = f'Delivered at {new_str}'
                elif datetime.now().time() > new_time.time():
                    pack.delivery_status()
                elif datetime.now() < datetime.combine(datetime.today(), time(8, 0, 0)):
                    pack.status = 'At Warehouse'
                    pack.delivery_status()
                    pack.status = f'Delivered at {new_str}'
        return question()
    if answer == 'SEARCH_STATUS':
        search2_answer = input('What is the package ID number that you wish to search for? ')
        try:
            value = int(search2_answer)
            pack = Package.pkg_table.get(value)[1]
            if 'Delivered' not in pack.status:
                pack.package_info()
            elif 'Delivered' in pack.status:
                new_str = pack.status.strip('Delivered at ')
                hr, mn = new_str.split(sep=':', maxsplit=1)
                new_time = datetime.combine(datetime.today(), time(int(hr), int(mn)))
                if new_time > datetime.now() > datetime.combine(datetime.today(), time(8, 0, 0)):
                    if pack.pkg_id == 9:
                        pack.status = 'Delayed'
                        pack.delivery_status()
                        pack.status = f'Delivered at {new_str}'
                    elif 'Delayed' in pack.notes and datetime.now() < datetime.combine(datetime.today(), time(9, 5, 0)):
                        pack.status = 'Delayed'
                        pack.delivery_status()
                        pack.status = f'Delivered at {new_str}'
                    else:
                        pack.status = 'En route'
                        pack.delivery_status()
                        pack.status = f'Delivered at {new_str}'
                elif datetime.now().time() > new_time.time():
                    pack.delivery_status()
                elif datetime.now() < datetime.combine(datetime.today(), time(8, 0, 0)):
                    pack.status = 'At Warehouse'
                    pack.delivery_status()
                    pack.status = f'Delivered at {new_str}'
            return question()
        except ValueError:
            print('Input must be an integer!')
            find_answer('SEARCH_STATUS')
    if answer == 'QUIT':
        exit()
    else:
        print('That command is not recognized.')
        gui_start()


# Time Complexity: O(1)
# Space Complexity: O(1)
def question():
    answer = input('What would you like to do? ')
    return find_answer(answer)


# Time Complexity: O(1)
# Space Complexity: O(1)
@gui_decorator
def gui_start():
    if truck3.driver.finish_time.time() <= datetime.now().time():
        print('All packages were delivered today at {} with a total combined mileage of {} miles'.format(truck3.driver.finish_time.time().strftime("%H:%M"), float("{:.2f}".format(Route.total_miles))))
    print('To display the status of all packages, type \'ALL\'.')
    print('To display the status of only one package, type \'SEARCH\'.')
    print('To display the delivery status of all packages, type \'ALL_STATUS\'.')
    print('To display the delivery status of only one package, type \'SEARCH_STATUS\'.')
    print('To end the program, type \'QUIT\'')
    return question()


total_time_end = datetime.now()
total_time_taken = total_time_end - total_time_start
seconds_in_day = 24 * 60 * 60
timedelta(hours=0, minutes=8, seconds=562000)
divmod(total_time_taken.days * seconds_in_day + total_time_taken.seconds, 60)
gui_start()
