import { Layout, Menu, Breadcrumb } from 'antd';
import "antd/dist/antd.css";
import PeopleList from './components/PeopleList';

const { Header, Content, Footer} = Layout

export default function App() {
  return (
    <div>
      <Layout className="layout">
        <Header>
          <div className="logo">
            <Menu theme="dark" mode="horizontal" defaultSelectedKeys={['1']}>
              <Menu.Item key="1">Home</Menu.Item>
            </Menu>
          </div>
        </Header>
        <Content style={{padding: '0 50px'}}>
            <div className="site-layout-content">
                
                <PeopleList></PeopleList>
            </div>
        </Content>
        <Footer style={{textAlign:'center'}}>
            eVaccine - Fullstack Week
        </Footer>

      </Layout>
    </div>
  );
}

