package com.weizhang;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * There are a total of n courses you have to take, labeled from 0 to n-1.
 *
 * Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
 *
 * Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?
 *
 * Example 1:
 *
 * Input: 2, [[1,0]]
 * Output: true
 * Explanation: There are a total of 2 courses to take.
 *              To take course 1 you should have finished course 0. So it is possible.
 * Example 2:
 *
 * Input: 2, [[1,0],[0,1]]
 * Output: false
 * Explanation: There are a total of 2 courses to take.
 *              To take course 1 you should have finished course 0, and to take course 0 you should
 *              also have finished course 1. So it is impossible.
 * Note:
 *
 * 1. The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
 * 2. You may assume that there are no duplicate edges in the input prerequisites.
 */

public class CourseSchedule {

    Set<Integer> visited;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Graph graph = new Graph(numCourses, prerequisites);
        visited = new HashSet<Integer>();
        for (int i = 0; i < numCourses; i++) {
            if (visited.contains(i)) {
                continue;
            }
            Stack<Integer> path = new Stack<Integer>();
            if (hasCircle(i, graph, path)) {
                return false;
            }
        }
        return true;
    }

    boolean hasCircle(int node, Graph graph, Stack<Integer> path) {
        if (path.contains(node)) {
            return true;
        } else {
            path.push(node);
            for (int nextNode: graph.adjacentList.get(node)) {
                boolean has = hasCircle(nextNode, graph, path);
                if (has) {
                    return true;
                }
            }
            path.pop();
            visited.add(node);
            return false;
        }
    }




    static class Graph {
        Graph(int numNodes, int[][] directedEdgeList) {
            // use adjacent list
            adjacentList = new ArrayList<ArrayList<Integer>>();
            for (int i = 0; i < numNodes; i++) {
                ArrayList<Integer> nodes = new ArrayList<Integer>();
                adjacentList.add(nodes);
            }
            for (int[] edge: directedEdgeList) {
                ArrayList<Integer> nodes = adjacentList.get(edge[0]);
                // assume no duplicate edges
                nodes.add(edge[1]);
            }
        }

        ArrayList<ArrayList<Integer>> adjacentList;
    }


    public static void main(String[] args) {
        int[][] prerequisites = new int[][]{{0, 1}, {0, 2}, {1, 2}};
        CourseSchedule problem = new CourseSchedule();
        boolean output = problem.canFinish(3, prerequisites);
    }
}
