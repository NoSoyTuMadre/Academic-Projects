"""
Toni Fields
Student #001307628
"""

from hash_table import HashTable


class Graph:
    main_adj_list = HashTable(27)

    # Time Complexity: O(1)
    # Space Complexity: O(1)
    def __init__(self):
        self.node_id = 0
        self.num_vertices = 0
        self.is_first = True
        self.memo_dest_list = []
        self.alt_dest_list = []
        self.dest_list = []
        self.path_list = []
        self.memo = []
        self.back_to_node0 = []
        self.removal_list = []
        self.min_element = [500, 500]
        self.main_path_sum = 0.0
        self.node0_path_sum = 0.0
        self.total_path_sum = 0.0
        self.last_min_value = []
        self.edges_list = HashTable()

    # Add vertices
    # Time Complexity: O(1)
    # Space Complexity: O(1)
    def add_vertex(self, node_id):
        new_node = Node(node_id)
        self.node_id = new_node.node_id
        # print(f'Get_node_id: {node_id}')
        self.dest_list.append(node_id)
        # self.show_destinations()
        self.num_vertices += 1

    # Add edges
    # Time Complexity: O(1)
    # Space Complexity: O(1)
    def add_edge(self, src_node_id, dest_node_id, miles):
        new_edge = Edge(src_node_id, dest_node_id, miles)
        self.edges_list.add(src_node_id, new_edge)

    # Time Complexity: O(1)
    # Space Complexity: O(1)
    def show_destinations(self):
        return print(f'Destinations: {self.dest_list}')

    # Time Complexity: O(N)
    # Space Complexity: O(1)
    def find_shortest_path(self, source_id):
        source_id = int(source_id)
        if self.is_first:
            self.path_list.append([source_id, 0])
            self.is_first = False
        find_list = list((self.main_adj_list.get(source_id))[1])
        find_list = [float(i) for i in find_list]
        self.dest_list = [int(i) for i in self.dest_list]
        if len(self.memo_dest_list) == 0:
            self.memo_dest_list = self.dest_list  # Make a copy of destinations for later
        else:
            self.dest_list = self.memo_dest_list
        if source_id == [self.dest_list[x] for x in range(len(self.dest_list))]:
            self.dest_list.remove(source_id)
        self.dest_list = set(self.dest_list)
        self.alt_dest_list = self.dest_list.copy()  # Create copy of dest_list for alternative route
        direct_path_x = []

        # Time Complexity: O(N^2)
        # Space Complexity: O(N)
        def iteration(list_a, remove_a=None):
            if remove_a is None:
                remove_a = []
            else:
                remove_a = list(remove_a)

            # Time Complexity: O(N)
            # Space Complexity: O(1)
            if len(remove_a) != 0:
                for r in range(len(remove_a)):
                    self.alt_dest_list.remove(remove_a[r])
            x = 0

            # Time Complexity: O(N^2)
            # Space Complexity: O(N)
            for each in list_a:
                for every_d in self.alt_dest_list:
                    if each != 0.0:
                        if every_d == x:
                            direct_path_x.append(['{} -->'.format(source_id), x, find_list[x]])
                            if each < self.min_element[1]:
                                self.min_element = [x, each]
                            else:
                                continue
                x += 1
            return self.min_element
        last_key = -1
        itt = []

        # Time Complexity: O(N)
        # Space Complexity: O(N)
        while last_key not in self.dest_list:
            if len(self.removal_list) == len(self.dest_list):
                itt = self.last_min_value
                break
            itt = iteration(find_list, self.removal_list)
            self.last_min_value = itt
            last_key = itt[0]
            if itt[0] != 500:
                self.removal_list.append(itt[0])
                find_list = list(self.main_adj_list.get(itt[0])[1])

        if not itt:
            itt = list(self.last_min_value)

        if [13, 7.2] in self.path_list and len(self.path_list) != len(self.dest_list) + 4:  # to accommodate the values manually deleted
            if itt[0] in self.dest_list:
                self.path_list.append(itt)
                self.dest_list.remove(itt[0])
                self.dest_list = list(self.dest_list)
                self.min_element = [500, 500]
                self.main_path_sum += itt[1]
                return itt
            else:
                return
        elif [13, 7.2] not in self.path_list and len(self.path_list) != len(self.dest_list) + 1:
            if itt[0] in self.dest_list:
                self.path_list.append(itt)
                self.dest_list.remove(itt[0])
                self.dest_list = list(self.dest_list)
                self.min_element = [500, 500]
                self.main_path_sum += itt[1]
                return itt
            else:
                return
        else:
            return itt

    # Time Complexity: O(N)
    # Space Complexity: O(1)
    def go_home(self, source_id):
        source_id = int(source_id)
        find_list = list((self.main_adj_list.get(source_id))[1])
        find_list = [float(i) for i in find_list]
        min_value = [0, find_list[0]]
        self.path_list.append(min_value)
        self.node0_path_sum += min_value[1]
        return min_value

    # Time Complexity: O(1)
    # Space Complexity: O(1)
    def show_path(self):
        return self.path_list


class Node:
    node_ids = []
    node_count = 0

    # Time Complexity: O(1)
    # Space Complexity: O(1)
    def __init__(self, node_id):
        self.node_id = node_id
        self.parent = None
        self.node_ids.append(self.node_id)
        self.node_count += 1


class Edge:
    # Time Complexity: O(1)
    # Space Complexity: O(1)
    def __init__(self, vertex_src, vertex_dest, miles):
        self.vertex_src = vertex_src
        self.vertex_dest = vertex_dest
        self.miles = miles

    # Time Complexity: O(1)
    # Space Complexity: O(1)
    def __str__(self):
        return "%d->%s %.5f" % (self.vertex_src, self.vertex_dest, self.miles)

    # Time Complexity: O(1)
    # Space Complexity: O(1)
    def __lt__(self, other):
        return self.miles < other.miles

    # Time Complexity: O(1)
    # Space Complexity: O(1)
    def __gt__(self, other):
        return self.miles > other.miles

    # Time Complexity: O(1)
    # Space Complexity: O(1)
    def source(self):
        return self.vertex_src

    # Time Complexity: O(1)
    # Space Complexity: O(1)
    def destination(self):
        return self.vertex_dest
