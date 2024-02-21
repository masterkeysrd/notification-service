export interface NotificationRecord {
    id: number;
    notificationId: string;
    userId: string;
    channel: string;
    categoryId: number;
    categoryName: string;
    destination: string;
    message: string;
    status: string;
    timestamp: number;
}