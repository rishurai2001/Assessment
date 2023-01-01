#include<fstream>
#include<iostream>
#include<cstring>
#include<vector>
#include<unordered_map>
#include<unordered_set>
#include<deque>
#include "json.hpp"
using json = nlohmann::json;



int main()
{

//Serializing into a output file
    std::ofstream f("serialized_output.json");

// Creating a JSON Object
    json j1 = {
            {"pi", 3.141},
            {"happy", true},
            {"name", "Niels"},
            {"nothing", nullptr},
            {"answer", {
                           {"everything", 42}
                   }},
            {"list", {1, 0, 2}},
            {"object", {
                           {"currency", "USD"},
                         {"value", 42.99}
                   }}
    };

// serialization of json to string using json.dump()
    std::string s = j1.dump(4);
    std::cout<<"---- serialization of json to string ---- "<<std::endl;
    std::cout<<s<<std::endl;

//Converting STL Containers to json objects
    std::cout<<"---- Converting STL Containers to json objects ---- "<<std::endl;
    std::vector<std::uint8_t> v = {'t', 'r', 'u', 'e'};
    json j_vector = json::parse(v.begin(), v.end());
//f<<j_vector;
    std::cout<<"1. Vector"<<std::endl;
    std::cout<<j_vector<<std::endl;

    std::unordered_set<std::string> c_uset {"one", "two", "three", "four", "one"};
    json j_uset(c_uset);
    f<<j_uset;
    std::cout<<"2. Unordered_set"<<std::endl;
    std::cout<<j_uset<<std::endl;

    std::unordered_map<const char*, double> c_umap { {"one", 1.2}, {"two", 2.3}, {"three", 3.4} };
    json j_umap(c_umap);
    std::cout<<"3. Unordered_map"<<std::endl;
    std::cout<<j_umap<<std::endl;

    std::unordered_multiset<std::string> c_umset {"one", "two", "one", "four"};
    json j_umset(c_umset);
    std::cout<<"4. unordered_multiset"<<std::endl;
    std::cout<<j_umset<<std::endl;

    std::deque<std::uint8_t> c_deque = {'1', '2', '4','5','7','9'};
    json j_deque = json::parse(c_deque.begin(),c_deque.end());
    std::cout<<"5. deque"<<std::endl;
    std::cout<<j_deque<<std::endl;

// Deserialize a string to json object

    std::cout<<"-------------------- Deserialization -------------";
// create object from string literal
    json j = "{ \"happy\": true, \"pi\": 3.141 }"_json;

    auto j2 = R"(
  {
    "happy": true,
    "pi": 3.141
  }
)"_json;

    std::cout << std::endl;
    std::cout<<j<<std::endl<<j2;
    return 0;
}