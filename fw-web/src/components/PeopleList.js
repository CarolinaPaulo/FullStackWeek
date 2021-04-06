import { Component } from "react";
import { Table, Button, message } from 'antd';
import Column from "antd/lib/table/Column";
import PeopleDataService from "../services/PeopleDataService";


export default class PeopleList extends Component{

     constructor(props){
         super(props)
         this.state ={
            people: [],
            message: null
         }
     }

     componentDidMount(){
         this.refreshPeople();
     }

     refreshPeople(){
         PeopleDataService.retriveAllPeople()
            .then(
                response => {
                    console.log(response);
                    this.setState({people: response.data})
                }
            )
     }

     success = (record) => {
        if(record.isVaccinated){
            record.isVaccinated = false;
        }else record.isVaccinated = true;
        PeopleDataService.updatePerson(record, record.PersonId);
        message.success('Status alterado com sucesso!');

     }




     render(){
         return(
              <div className="container">
                  <h2> PEOPLE ON THE DATABASE </h2>
                  <div className="container">
                        <Table dataSource={this.state.people}>
                            <Column title="NAME" dataIndex="name" key="name"/>
                            <Column title="CPF" dataIndex="cpf" key="cpf"/>
                            <Column title="TELEFONE" dataIndex="telefone" key="telefone"/>
                            <Column title="EMAIL" dataIndex="email" key="email"/>
                            <Column title="IS VACCINATED" dataIndex="isVaccinated" key="isVaccinated" 
                                render={(text, record) => (<p>{String(record.isVaccinated)}</p>)}/>
                            <Column title="UPDATE"  key="update" 
                                render={(text, record) => (<Button onClick={() => this.success(record)} type="primary">Update Status</Button>)} />
                        </Table>
                  </div>
              </div>
         )
     }


}