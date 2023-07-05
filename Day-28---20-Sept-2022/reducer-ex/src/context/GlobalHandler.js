import { createContext } from "react"
import AppReducer from "./AppReducer";

export const initialState = {
    contacts: [
        {
            id: 1,
            name: 'John',
            email: 'john@gmail.com',
            phone: 9897647788
        }
    ]
}

export const GlobalContext = createContext(initialState);

export const GlobalHandler = ({ children }) => {

    const [state, dispatch] = useReducer(AppReducer, initialState)

    function addcontact() {
        dispatch({
            type: 'ADD_CONTACT',
            payload: contact
        })
    }

    function editcontact() {
        dispatch({
            type: 'EDIT_CONTACT',
            payload: contact
        })
    }

    function deletecontact() {
        dispatch({
            type: 'REMOVE_CONTACT',
            payload: id
        })
    }

    return (
        < GlobalContext.Provider value={{
            contacts: state.contacts,
            addcontact,
            editcontact,
            deletecontact
        }}>
            {children}
        </GlobalContext.Provider >
    );
}


