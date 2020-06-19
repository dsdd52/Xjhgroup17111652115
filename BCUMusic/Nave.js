import React, {Component} from 'react';
import { NavigationContainer } from '@react-navigation/native';
import { createStackNavigator } from '@react-navigation/stack';
import { NavigationActions,StackActions  } from 'react-navigation' ;
import WelcomePage from './App';
import Home from "./HomePage"
import {View,}from 'react-native';
let Stack = createStackNavigator();

const resetAction = StackActions.reset({
    index: 0,
    actions: [
        NavigationActions.navigate({ routeName: 'Home' }),
    ]
});

export default class Nave extends Component {
    constructor(props) {
        super(props);
        this.state={isShowAd:false}
    }
    _showWelcomePage=({navigation})=>{
        return(<WelcomePage AppNavigation={navigation} setN={this.setIsShowAd} />)
    }
    _showHome=(navigation)=>{
       return(<Home AppNavigation={navigation}/>)
    }
    setIsShowAd=()=>{
        this.setState({isShowAd:true})
    }

    render() {
        return (
            <View style={{flex:1}}>
                <NavigationContainer
                    independent={true}
                >
                    <Stack.Navigator>
                        {this.state.isShowAd ? (
                            <>

                                <Stack.Screen name="Home" options={{headerShown:false}} component={this._showHome} />
                            </>
                        ):(
                            <>
                                <Stack.Screen name="WelcomePage" options={{headerShown:false}} component={this._showWelcomePage} />
                                <Stack.Screen name="Home" options={{headerShown:false}} component={this._showHome} />
                            </>
                            )

                        }

                    </Stack.Navigator>
                </NavigationContainer>
            </View>
        );
    }
}
