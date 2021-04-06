import axios from 'axios';

const API_URL = 'http://localhost:8080/'

class PeopleDataService{
    retriveAllPeople(){
        return axios.get(`${API_URL}people`);
    }

    updatePerson(person, personId){
        return axios.put(`${API_URL}people/${personId}`, person);
    }
    
}


export default new PeopleDataService();