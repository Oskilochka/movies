import axios from "axios";
import {
    useQuery,
    useMutation,
    useQueryClient, QueryKey
} from "@tanstack/react-query"

const BASE_URL =  "http://localhost:8080/"

const client = axios.create({
    baseURL: BASE_URL
})

export const request = async (options: any) => {

    debugger

    const onSuccess = (response: any) => {
        debugger

        return response?.data;
    };

    const onError = (error: any) => {
        return Promise.reject(error.response?.data);
    };

    return client(options).then(onSuccess).catch(onError);
};

export const useApiGet = (key: QueryKey, fn: any, options: any) => useQuery({
    queryKey: key,
    queryFn: fn,
    ...options
})

export const useApiSend = (fn: any, success: any, error: any, options?: any,  invalidateKey?: any) => {
    const queryClient = useQueryClient();

    return useMutation({
        mutationFn: fn,
        onSuccess: (data) => {
            invalidateKey &&
            invalidateKey.forEach((key: any) => {
                queryClient.invalidateQueries(key);
            });
            success && success(data);
        },
        onError: error,
        retry: 2,
        ...options,
    });
};
